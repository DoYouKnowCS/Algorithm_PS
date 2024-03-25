let inputs = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
function solution(input) {
  let n = +input[0];
  let arr = input[1].split(" ").map(d => +d);
  let min = arr[0];
  let dp = new Array(n).fill(0);
  dp[0] = 0;
  for (var i = 1; i < n; i++) {
    if (arr[i] < min) min = arr[i];
    dp[i] = arr[i] - min > dp[i - 1] ? arr[i] - min : dp[i - 1];
  }
  console.log(Math.max(...dp));
}
solution(inputs);
