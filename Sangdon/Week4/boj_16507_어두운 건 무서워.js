let inputs = require("fs")
  .readFileSync("boj_16507_어두운 건 무서워.txt")
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  let [r, c, q] = input[0].split(" ").map(Number);
  let dp = Array.from(Array(r + 1), () => Array(c + 1).fill(0));
  let board = [];
  for (var i = 1; i < 1 + r; i++) {
    board.push(input[i].split(" ").map(Number));
  }
  // 점화식을 세우자
  dp[1][1] = board[0][0];
  for (var x = 1; x <= r; x++) {
    for (var y = 1; y <= c; y++) {
      dp[x][y] =
        dp[x - 1][y] + dp[x][y - 1] - dp[x - 1][y - 1] + board[x - 1][y - 1];
    }
  }
  for (var i = 1 + r; i < 1 + r + q; i++) {
    let [r1, c1, r2, c2] = input[i].split(" ").map(Number);
    // console.log(r1, c1, r2, c2);
    let divider = (r2 - r1 + 1) * (c2 - c1 + 1);
    let ans = dp[r2][c2] - dp[r2][c1 - 1] - dp[r1 - 1][c2] + dp[r1 - 1][c1 - 1];
    console.log(Math.floor(ans / divider));
  }
}
solution(inputs);
