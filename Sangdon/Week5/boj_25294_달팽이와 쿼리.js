let inputs = require("fs")
  .readFileSync("boj_25294_달팽이와 쿼리.txt")
  .toString()
  .trim()
  .split("\n");

const makeSquare = (n, type, a, b) => {
  let board = Array.from(Array(n), () => Array(n).fill(0));
  let hash = {};
  let y = 0;
  let x = 0;
  let idx = 1;
  while (n > 0) {
    // 오른쪽
    for (var i = 0; i < n; i++) {
      hash[idx] = [x, y];
      board[x][y++] = idx++;
    }
    n--;
    // 아래쪽
    y--;
    x++;
    for (var i = 0; i < n; i++) {
      hash[idx] = [x, y];
      board[x++][y] = idx++;
    }
    // 왼쪽
    x--;
    y--;
    for (var i = 0; i < n; i++) {
      hash[idx] = [x, y];
      board[x][y--] = idx++;
    }
    n--;

    // 위쪽
    y++;
    x--;
    for (var i = 0; i < n; i++) {
      hash[idx] = [x, y];
      board[x--][y] = idx++;
    }
    y++;
    x++;
  }
  if (type === 1) {
    return board[a - 1][b - 1].toString();
  } else {
    let [q, w] = hash[a];
    return `${q + 1} ${w + 1}`;
  }
};

function solution(input) {
  let q = +input[0];
  for (var i = 1; i < 1 + q; i++) {
    let [num, n, x, y] = input[i].split(" ").map(Number);
    switch (num) {
      case 1:
        console.log(makeSquare(n, 1, x, y));
        break;
      case 2:
        console.log(makeSquare(n, 2, x));
        break;
    }
  }
}
solution(inputs);
