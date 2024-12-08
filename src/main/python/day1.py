import re

input_data = """
3   4
4   3
2   5
1   3
3   9
3   3
"""

pattern = re.compile(r"(\d+)\s+(\d+)")
matches = pattern.findall(input_data)

sorted_l = sorted(int(m[0]) for m in matches)
sorted_r = sorted(int(m[1]) for m in matches)

distance_sum = sum(abs(l - r) for l, r in zip(sorted_l, sorted_r))

print(distance_sum)