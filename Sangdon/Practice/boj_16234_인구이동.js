let inputs = require("fs")
  .readFileSync("boj_16234_인구이동.txt")
  .toString()
  .trim()
  .split("\n");
function solution(input) {
  let answer = 0;
  let [n, l, r] = input[0].split(" ").map(d => +d);
  let dx = [-1, 1, 0, 0];
  let dy = [0, 0, -1, 1];
  let board = [];
  for (var i = 1; i < 1 + n; i++) {
    board.push(input[i].split(" ").map(d => +d));
  }

  while (1) {
    let flag = false;
    let visited = Array.from(Array(n), () => Array(n).fill(false));
    for (var i = 0; i < n; i++) {
      for (var k = 0; k < n; k++) {
        if (!visited[i][k]) {
          let queue = [[i, k]];
          let visitedRecord = [];
          let totalNum = 0;
          let total = 0;
          while (queue.length) {
            let [x, y] = queue.shift();
            totalNum++;
            visited[x][y] = true;
            total += board[x][y];
            visitedRecord.push([x, y]);

            for (var z = 0; z < 4; z++) {
              let lx = x + dx[z];
              let ly = y + dy[z];
              if (lx >= 0 && ly >= 0 && lx < n && ly < n) {
                let dif = Math.abs(board[x][y] - board[lx][ly]);
                if (!visited[lx][ly] && dif >= l && dif <= r) {
                  queue.push([lx, ly]);
                  flag = true;
                }
              }
            }
          }
          let avg = Math.floor(total / totalNum);
          for (var a = 0; a < visitedRecord.length; a++) {
            let [nX, nY] = visitedRecord[a];
            board[nX][nY] = avg;
          }
        }
      }
    }
    if (!flag) break;
    answer++;
  }
  console.log(answer);
}
solution(inputs);
