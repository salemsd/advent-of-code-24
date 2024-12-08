enum State {
  ASC,
  DESC
}

record Pair(int l, int r) {}

boolean isValid(int[] arr) {
  if (arr.length < 2) {
    return true;
  }

  var initialState = arr[0] < arr[1] ? State.ASC : State.DESC;
  for (var i = 1; i < arr.length; i++) {
    var pair = new Pair(arr[i - 1], arr[i]);
    var currentState = pair.l() < pair.r() ? State.ASC : State.DESC;
    if (initialState != currentState) {
      return false;
    }

    var diff = Math.abs(pair.l() - pair.r());
    if (diff < 1 || diff > 3) {
      return false;
    }
  }

  return true;
}


void main() {
  var input =
          """
          7 6 4 2 1
          1 2 7 8 9
          9 7 6 2 1
          1 3 2 4 5
          8 6 4 4 1
          1 3 6 7 9
          """;

  var lines = input.lines()
                  .map(s -> s.split("\\s+"))
                  .map(line -> Arrays.stream(line).mapToInt(Integer::parseInt).toArray())
                  .toArray(int[][]::new);

  var safe = Arrays.stream(lines)
          .map(this::isValid)
          .filter(b -> b)
          .count();

  System.out.println(safe);
}