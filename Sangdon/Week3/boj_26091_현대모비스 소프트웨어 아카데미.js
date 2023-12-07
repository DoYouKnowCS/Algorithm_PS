let inputs = require("fs")
  .readFileSync("boj_26091_현대모비스 소프트웨어 아카데미.txt")
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  let [n, m] = input[0].split(" ").map(d => +d);
  let arr = input[1].split(" ").map(d => +d);
  let ans = 0;
  arr.sort((a, b) => a - b);
  let l = 0;
  let r = arr.length - 1;
  while (l < r) {
    if (arr[l] + arr[r] < m) {
      l++;
    } else if (arr[l] + arr[r] >= m) {
      l++;
      r--;
      ans++;
    }
  }
  console.log(ans);
}
solution(inputs);
