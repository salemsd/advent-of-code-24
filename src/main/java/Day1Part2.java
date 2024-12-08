static final Pattern LINE = Pattern.compile("(\\d+)\\s+(\\d+)\n+");

long countOccurences(int number, int[] numbers) {
  return Arrays.stream(numbers)
          .filter(n -> number == n)
          .count();
}

void main() {
  var input =
          """
          3   4
          4   3
          2   5
          1   3
          3   9
          3   3
          """;

  var left = LINE.matcher(input).results()
          .mapToInt(m -> Integer.parseInt(m.group(1)))
          .toArray();

  var right = LINE.matcher(input).results()
          .mapToInt(m -> Integer.parseInt(m.group(2)))
          .toArray();

  var score = Arrays.stream(left)
          .mapToLong(l -> countOccurences(l, right) * l)
          .sum();

  System.out.println(score);
}