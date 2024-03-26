let inputs = require("fs")
  .readFileSync("boj_12865_평범한 배낭.txt")
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  let [n, k] = input[0].split(" ").map(d => +d);
  let weight = [];
  for (var i = 1; i < 1 + n; i++) {
    weight.push(input[i].split(" ").map(d => +d));
  }
  let dp = Array.from(Array(k + 1), () => Array(n + 1).fill(0));
  for (var i = 1; i < k + 1; i++) {
    for (var j = 1; j <= weight.length; j++) {
      if (i - weight[j - 1][0] >= 0) {
        dp[i][j] = Math.max(
          dp[i - weight[j - 1][0]][j - 1] + weight[j - 1][1],
          dp[i][j - 1]
        );
      } else {
        dp[i][j] = dp[i][j - 1];
      }
    }
  }
  console.log(dp[k][n]);
}
solution(inputs);
