let inputs = require("fs")
  .readFileSync("boj_19236_청소년 상어.txt")
  .toString()
  .trim()
  .split("\n");

const fishMove = (board, hash, num) => {
  let [x, y] = hash[num];
  let dir = board[x][y][1];
  let nX = x;
  let nY = y;
  switch (dir) {
    case 1:
      nX--;
      break;
    case 2:
      nX--;
      nY--;
      break;
    case 3:
      nY--;
      break;
    case 4:
      nX++;
      nY--;
      break;
    case 5:
      nX++;
      break;
    case 6:
      nX++;
      nY++;
      break;
    case 7:
      nY++;
      break;
    case 8:
      nX--;
      nY++;
      break;
  }
  if (nX >= 0 && nY >= 0 && nX < 4 && nY < 4 && board[nX][nY].length !== 3) {
    let cNum = board[nX][nY][0];
    let tmp = board[nX][nY];
    board[nX][nY] = board[x][y];
    board[x][y] = tmp;
    hash[cNum] = [x, y];
    hash[num] = [nX, nY];
  }
  console.log(hash, board);
};
function solution(input) {
  let board = Array.from(Array(4), () => new Array(4));
  let answer = 0;
  let hash = {};
  for (var i = 0; i < 4; i++) {
    let m = 0;
    let arr = input[i].split(" ").map(d => +d);
    for (var k = 0; k < arr.length; k += 2) {
      hash[arr[k]] = [i, m];
      board[i][m++] = [arr[k], arr[k + 1]];
    }
  }
  answer += board[0][0][0];
  hash[board[0][0][0]] = [];
  board[0][0] = [0, 0, board[0][0][1]];
  for (var i = 1; i <= 16; i++) {
    if (hash[i].length !== 0) {
      fishMove(board, hash, i);
    }
  }
  for (var i = 1; i <= 16; i++) {}
  fishMove(board, hash, 1);
  const sharkMove = (board, result) => {};
  //   console.log(hash);
  //   console.log(board);
}
solution(inputs);
