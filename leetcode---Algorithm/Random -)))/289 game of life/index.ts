/**
 Do not return anything, modify board in-place instead.
 */
interface CellData {
  deadNeighbors: number;
  liveNeighbors: number;
}

function gameOfLife(board: number[][]): void {
  const rows = board.length;
  const columns = board[0].length;

  // Initial matrix store the number of dead and live cell neighbors
  const boardInfoNeighbors = constructorBoardInfoNeighbors(rows, columns);

  // Initial matrix store the cell had calculated next state
  const boardCalculatedCell = constructBoardCalculatedCell(rows, columns);

  // Calculate next state for current board
  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < columns; j++) {
      calculateNextStateAndNeighborsCellOfCurrentCell(
        i,
        j,
        board,
        boardInfoNeighbors,
        boardCalculatedCell
      );
    }
  }
}

function calculateNextStateAndNeighborsCellOfCurrentCell(
  x: number,
  y: number,
  board: number[][],
  boardInfoNeighbors: CellData[][],
  boardCalculatedCell: boolean[][]
): void {
  const rows = board.length;
  const columns = board[0].length;
  const currentCellState = board[x][y];

  for (let newX = x - 1; newX <= x + 1; newX++) {
    for (let newY = y - 1; newY <= y + 1; newY++) {
      if (
        newX < 0 ||
        newX >= rows ||
        newY < 0 ||
        newY >= columns ||
        (newX === x && newY === y)
      ) {
        continue;
      }

      if (boardCalculatedCell[newX][newY] === true) {
        continue;
      }

      const currentStateNeighbor = board[newX][newY];

      const infoCurrentState: CellData = {
        deadNeighbors:
          currentStateNeighbor === 0
            ? boardInfoNeighbors[x][y].deadNeighbors + 1
            : boardInfoNeighbors[x][y].deadNeighbors,
        liveNeighbors:
          currentStateNeighbor === 1
            ? boardInfoNeighbors[x][y].liveNeighbors + 1
            : boardInfoNeighbors[x][y].liveNeighbors,
      };

      // Calculate the number of live and dead neighbors cell for current cell
      boardInfoNeighbors[x][y] = infoCurrentState;

      const infoCurrentNeighborState: CellData = {
        deadNeighbors:
          currentCellState === 0
            ? boardInfoNeighbors[newX][newY].deadNeighbors + 1
            : boardInfoNeighbors[newX][newY].deadNeighbors,
        liveNeighbors:
          currentCellState === 1
            ? boardInfoNeighbors[newX][newY].liveNeighbors + 1
            : boardInfoNeighbors[newX][newY].liveNeighbors,
      };
      // calculate the number of dead or live neighbors for the current neighbors
      boardInfoNeighbors[newX][newY] = infoCurrentNeighborState
    }
  }

  if (currentCellState === 1) {
    if (
      boardInfoNeighbors[x][y].liveNeighbors < 2 ||
      boardInfoNeighbors[x][y].liveNeighbors > 3
    ) {
      board[x][y] = 0;
    }

    if (
      boardInfoNeighbors[x][y].liveNeighbors === 2 ||
      boardInfoNeighbors[x][y].liveNeighbors === 3
    ) {
      board[x][y] = 1;
    }
  }

  if (currentCellState === 0) {
    if (boardInfoNeighbors[x][y].liveNeighbors === 3) {
      board[x][y] = 1;
    } else {
      board[x][y] = 0;
    }
  }

  boardCalculatedCell[x][y] = true
}

function constructorBoardInfoNeighbors(
  rows: number,
  columns: number
): CellData[][] {
  const arr = new Array(rows);

  for (let i = 0; i < rows; i++) {
    arr[i] = new Array(columns);
    for (let j = 0; j < columns; j++) {
      arr[i][j] = { deadNeighbors: 0, liveNeighbors: 0 } as CellData;
    }
  }

  return arr;
}

function constructBoardCalculatedCell(
  rows: number,
  columns: number
): boolean[][] {
  const arr = new Array(rows);

  for (let i = 0; i < rows; i++) {
    arr[i] = new Array(columns);
    for (let j = 0; j < columns; j++) {
      arr[i][j] = false;
    }
  }

  return arr;
}

const board = [
  [0, 1, 0],
  [0, 0, 1],
  [1, 1, 1],
  [0, 0, 0],
];

gameOfLife(board);