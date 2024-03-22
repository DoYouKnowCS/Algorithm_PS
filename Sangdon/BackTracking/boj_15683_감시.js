let inputs = require("fs")
  .readFileSync("boj_15683_감시.txt")
  .toString()
  .trim()
  .split("\n");

const deepCopyGraph = graph => {
  const newGraph = [];
  graph.forEach(row => {
    newGraph.push([...row]);
  });
  return newGraph;
};

const count = board => {
  let count = 0;
  for (var i = 0; i < board.length; i++) {
    for (var k = 0; k < board[0].length; k++) {
      if (board[i][k] === 0) count++;
    }
  }
  return count;
};
const up = (board, x, y) => {
  let nX = x--;
  while (1 && nX >= 0) {
    if (board[nX][y] === 0) {
      board[nX][y] = "#";
      nX--;
    } else if (
      (board[nX][y] >= 1 && board[nX][y] <= 5) ||
      board[nX][y] === "#"
    ) {
      nX--;
    } else if (board[nX][y] === 6 || nX < 0) {
      break;
    }
  }
  return board;
};
const down = (board, x, y) => {
  let n = board.length;
  let nX = x++;
  while (1 && nX < n) {
    if (board[nX][y] === 0) {
      board[nX][y] = "#";
      nX++;
    } else if (
      (board[nX][y] >= 1 && board[nX][y] <= 5) ||
      board[nX][y] === "#"
    ) {
      nX++;
    } else if (board[nX][y] === 6 || nX >= n) {
      break;
    }
  }
  return board;
};
const right = (board, x, y) => {
  let m = board[0].length;
  let nY = y++;
  while (1 && nY < m) {
    if (board[x][nY] === 0) {
      board[x][nY] = "#";
      nY++;
    } else if (
      (board[x][nY] >= 1 && board[x][nY] <= 5) ||
      board[x][nY] === "#"
    ) {
      nY++;
    } else if (board[x][nY] === 6 || nY >= m) {
      break;
    }
  }
  return board;
};
const left = (board, x, y) => {
  let nY = y--;
  while (1 && nY >= 0) {
    if (board[x][nY] === 0) {
      board[x][nY] = "#";
      nY--;
    } else if (
      (board[x][nY] >= 1 && board[x][nY] <= 5) ||
      board[x][nY] === "#"
    ) {
      nY--;
    } else if (board[x][nY] === 6 || nY < 0) {
      break;
    }
  }
  return board;
};

const calSight = (board, num, dir, cctv) => {
  let [x, y] = cctv;
  switch (num) {
    case 1:
      if (dir === 0) {
        board = right(board, x, y);
      } else if (dir === 1) {
        board = down(board, x, y);
      } else if (dir === 2) {
        board = left(board, x, y);
      } else {
        board = up(board, x, y);
      }
      break;
    case 2:
      if (dir === 0 || dir === 2) {
        let newBoard = right(board, x, y);
        board = left(newBoard, x, y);
      } else if (dir === 1 || dir === 3) {
        let newBoard = up(board, x, y);
        board = down(newBoard, x, y);
      }
      break;
    case 3:
      if (dir === 0) {
        let newBoard = up(board, x, y);
        board = right(newBoard, x, y);
      } else if (dir === 1) {
        let newBoard = down(board, x, y);
        board = right(newBoard, x, y);
      } else if (dir === 2) {
        let newBoard = down(board, x, y);
        board = left(newBoard, x, y);
      } else {
        let newBoard = down(board, x, y);
        board = up(newBoard, x, y);
      }
      break;
    case 4:
      if (dir === 0) {
        let newBoard1 = up(board, x, y);
        let newBoard2 = right(newBoard1, x, y);
        board = left(newBoard2, x, y);
      } else if (dir === 1) {
        let newBoard1 = up(board, x, y);
        let newBoard2 = right(newBoard1, x, y);
        board = down(newBoard2, x, y);
      } else if (dir === 2) {
        let newBoard1 = left(board, x, y);
        let newBoard2 = right(newBoard1, x, y);
        board = left(newBoard2, x, y);
      } else {
        let newBoard1 = up(board, x, y);
        let newBoard2 = down(newBoard1, x, y);
        board = left(newBoard2, x, y);
      }
      break;
    case 5:
      let newBoard1 = up(board, x, y);
      let newBoard2 = right(newBoard1, x, y);
      let newBoard3 = down(newBoard2, x, y);
      board = left(newBoard3, x, y);
      break;
  }
  return board;
};
function solution(input) {
  let [n, m] = input[0].split(" ").map(d => +d);
  let board = [];
  let answer = 0;
  let cctv = [];
  for (var i = 1; i < 1 + n; i++) {
    board.push(input[i].split(" ").map(d => +d));
  }
  for (var i = 0; i < n; i++) {
    for (var k = 0; k < m; k++) {
      if (board[i][k] >= 1 && board[i][k] <= 5) {
        cctv.push([i, k, board[i][k]]);
      } else if (board[i][k] === 0) {
        answer++;
      }
    }
  }
  let max = 0;

  const back = (boards, depth) => {
    let slice = deepCopyGraph(boards);
    if (depth < 0) {
      console.log(slice);
      return;
    }
    let newCctv = cctv[depth];
    for (var j = 0; j < 4; j++) {
      console.log(j);
      let newBoard = calSight(boards, newCctv[2], j, [newCctv[0], newCctv[1]]);
      back(newBoard, depth - 1);
      boards = slice;
    }
  };
  back(board, cctv.length - 1);
  console.log(board);
  //   console.log(max);
}

solution(inputs);
