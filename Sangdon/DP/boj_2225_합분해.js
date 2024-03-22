let inputs = require("fs")
  .readFileSync("boj_2225_합분해.txt")
  .toString()
  .trim()
  .split("\n");
function solution(input) {
  let [n, k] = input[0].split(" ").map(d => +d);
  let dp = Array.from(Array(n + 1), () => Array(n + 1).fill(0));
  for (var i = 0; i < n + 1; i++) {
    dp[1][i] = 1;
  }
  for (var j = 0; j < n + 1; j++) {
    for (var q = 0; q <= j; q++) {
      dp[k][j] += dp[k - 1][q] % 1000000000;
    }
  }
  console.log(dp);
}
solution(inputs);
