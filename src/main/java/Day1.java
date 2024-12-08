/*

3   4
4   3
2   5
1   3
3   9
3   3

 */

static final Pattern LINE = Pattern.compile("(\\d+)\\s+(\\d+)\n+");

void main() {
  var input =
          """
          0 0
          """;

  var sortedL = LINE.matcher(input).results()
          .mapToInt(m -> Integer.parseInt(m.group(1)))
          .sorted()
          .toArray();

  var sortedR = LINE.matcher(input).results()
          .mapToInt(m -> Integer.parseInt(m.group(2)))
          .sorted()
          .toArray();

  var distanceSum = IntStream.range(0, sortedL.length)
                  .map(i -> Math.abs(sortedL[i] - sortedR[i]))
                  .sum();

  System.out.println(distanceSum);
}
