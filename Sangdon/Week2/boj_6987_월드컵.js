function solution() {
  let len = result.length - 1;

  result.sort((a, b) => {
    return b[0] - a[0];
  });

  const board = Array.from(Array(6), () => Array(3).fill(0));

  for (let i = 0; i < result.length; i++) {
    const [win, draw, defeat] = result[i];
    board[i][0] = win;
    board[i][1] = draw;

    for (let j = len; j >= len - win + 1; j--) {
      board[j][2] += 1;
    }
    console.log(board);
  }
  for (let i = 0; i < result.length; i++) {
    if (board[i].join("") !== result[i].join("")) return 0;
  }

  return 1;
}

const result = [
  [4, 1, 0],
  [3, 0, 2],
  [4, 1, 0],
  [1, 1, 3],
  [0, 0, 5],
  [1, 1, 3],
];

console.log(solution());
