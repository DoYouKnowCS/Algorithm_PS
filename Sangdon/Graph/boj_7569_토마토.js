let inputs = require("fs")
  .readFileSync("boj_7569_토마토.txt")
  .toString()
  .trim()
  .split("\n");

const check = (board, height, m, n) => {
  let isAll = true;

  for (var i = 0; i < height; i++) {
    for (var k = 0; k < n; k++) {
      for (var j = 0; j < m; j++) {
        if (board[i][k][j] === 0) {
          isAll = false;
          break;
        }
      }
    }
  }
  if (!isAll) return false;
  return true;
};
function solution(input) {
  let [m, n, h] = input[0].split(" ").map(d => +d);
  let a = 1;
  let answer = -1;
  let dx = [-1, 1, 0, 0];
  let dy = [0, 0, -1, 1];
  let vM = [-1, 1];
  let tomato = [];
  let board = {};
  let visited = {};
  for (var i = 0; i < h; i++) {
    let arr = [];
    for (var k = 0; k < n; k++) {
      let garo = input[a++].split(" ").map(d => +d);
      garo.forEach((d, idx) => {
        if (d === 1) {
          tomato.push([i, k, idx]);
        }
      });
      arr.push(garo);
    }
    let nV = Array.from(Array(n), () => Array(m).fill(0));
    visited[i] = nV;
    board[i] = arr;
  }

  while (1) {
    let newTomato = [];
    while (tomato.length) {
      let [height, x, y] = tomato.pop();
      for (var i = 0; i < 4; i++) {
        let nX = x + dx[i];
        let nY = y + dy[i];
        if (
          nX >= 0 &&
          nY >= 0 &&
          nX < n &&
          nY < m &&
          board[height][nX][nY] === 0 &&
          visited[height][nX][nY] === 0
        ) {
          board[height][nX][nY] = 1;
          visited[height][nX][nY] = 1;
          newTomato.push([height, nX, nY]);
        }
      }
      for (var k = 0; k < 2; k++) {
        let nH = height + vM[k];
        if (
          nH >= 0 &&
          nH < h &&
          visited[nH][x][y] === 0 &&
          board[nH][x][y] === 0
        ) {
          board[nH][x][y] = 1;
          visited[nH][x][y] = 1;
          newTomato.push([nH, x, y]);
        }
      }
    }
    answer++;
    if (newTomato.length === 0) {
      break;
    }
    tomato.push(...newTomato);
  }
  let result = check(board, h, m, n);
  if (!result) {
    console.log(-1);
  } else {
    console.log(answer);
  }
}
solution(inputs);
