let inputs = require("fs")
  .readFileSync("boj_14503_로봇 청소기.txt")
  .toString()
  .trim()
  .split("\n");

const changeDir = dir => {
  switch (dir) {
    case 0:
      return [
        [0, 1, 0, -1],
        [-1, 0, 1, 0],
        [3, 2, 1, 0],
      ];
    case 1:
      return [
        [-1, 0, 1, 0],
        [0, -1, 0, 1],
        [0, 3, 2, 1],
      ];
    case 2:
      return [
        [0, -1, 0, 1],
        [1, 0, -1, 0],
        [1, 0, 3, 2],
      ];
    case 3:
      return [
        [1, 0, -1, 0],
        [0, 1, 0, -1],
        [2, 1, 0, 3],
      ];
  }
};

const back = (x, y, dir) => {
  switch (dir) {
    case 0:
      return [x + 1, y];
    case 1:
      return [x, y - 1];
    case 2:
      return [x - 1, y];
    case 3:
      return [x, y + 1];
  }
};
function solution(input) {
  let [n, m] = input[0].split(" ").map(d => +d);
  let [x, y, d] = input[1].split(" ").map(d => +d);
  let count = 1;
  let visited = Array.from(Array(n), () => Array(m).fill(0));
  let board = [];
  for (var i = 2; i < 2 + n; i++) {
    board.push(input[i].split(" ").map(d => +d));
  }
  let queue = [[x, y, d]];
  while (queue.length) {
    let [cX, cY, cD] = queue.shift();
    let [dx, dy, cdArr] = changeDir(cD);
    visited[cX][cY] = 1;

    let isVacuum = false;
    for (var k = 0; k < 4; k++) {
      let lX = cX + dx[k];
      let lY = cY + dy[k];
      if (lX >= 0 && lY >= 0 && lX < n && lY < m) {
        if (!visited[lX][lY] && board[lX][lY] !== 1) {
          isVacuum = true;
          count++;
          queue.push([lX, lY, cdArr[k]]);
          break;
        }
      }
    }
    if (!isVacuum) {
      let [nX, nY] = back(cX, cY, cD);
      if (board[nX][nY] === 1) break;
      queue.push([nX, nY, cD]);
    }
  }

  console.log(count);
}
solution(inputs);
