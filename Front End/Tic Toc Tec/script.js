var gamer;

function show() 
{
  gamer = document.getElementById("x").value;

  var chkYes = document.getElementById("x");
  var game = document.getElementById("a");
  game.style.display = chkYes.checked ? "block" : "none";
  document.getElementById("x").disabled = true;
  document.getElementById("o").disabled = true;
}

function show1() 
{
  gamer = document.getElementById("o").value;

  console.log(gamer);
  var chkYes = document.getElementById("o");
  var game = document.getElementById("a");
  game.style.display = chkYes.checked ? "block" : "none";
  document.getElementById("x").disabled = true;
  document.getElementById("o").disabled = true;
}

const ticTacToeGame = new TicTacToeGame();
ticTacToeGame.start();

function TicTacToeGame() 
{
  const board = new Board();
  const humanPlayer = new HumanPlayer(board);
  const computerPlayer = new ComputerPlayer(board);
  let turn = 0;

  this.start = function() 
  {
    const config = 
    { 
      childList: true 
    };
    const observer = new MutationObserver(() => takeTurn());
    board.positions.forEach((el) => observer.observe(el, config));
    takeTurn();
  }

  function takeTurn() 
  {
    if (board.checkForWinner()) 
    {
      return;
    }

    if (turn % 2 === 0) 
    {
      humanPlayer.takeTurn();
    } 
    else 
    {
      computerPlayer.takeTurn();
    }

    turn++;
  };
}

function Board() 
{
  this.positions = Array.from(document.querySelectorAll('.col'));

  this.checkForWinner = function() 
  {
    let winner = false;

    const winningCombinations = [
    [0,1,2],
    [3,4,5],
    [6,7,8],
    [0,4,8],
    [2,4,6],
    [0,3,6],
    [1,4,7],
    [2,5,8]

    ];

    const positions = this.positions;

    winningCombinations.forEach((winningCombo) => 
    {
      const pos0InnerText = positions[winningCombo[0]].innerText;
      const pos1InnerText = positions[winningCombo[1]].innerText;
      const pos2InnerText = positions[winningCombo[2]].innerText;
      const isWinningCombo = pos0InnerText !== '' &&
      pos0InnerText === pos1InnerText && pos1InnerText === pos2InnerText;
      if (isWinningCombo) 
      {
        winner = true;
        winningCombo.forEach((index) => 
        {
          positions[index].className += ' winner';
        })
        alert("Winner is " + "'" +pos0InnerText + "'");
      }
    });

    return winner;
  }
}

function ComputerPlayer(board) 
{
  this.takeTurn = function() {
    const avilablePositions = board.positions.filter((p) => p.innerText === '');
    const move = Math.floor(Math.random() * avilablePositions.length);
    if (gamer == "user_x") 
    {
      avilablePositions[move].innerText = 'o';
    } else {
      avilablePositions[move].innerText = 'x';
    }
  }
}

function HumanPlayer(board)
{
  this.takeTurn = function() 
  {
    board.positions.forEach(el =>
      el.addEventListener('click', handleTurnTaken));
  }

  function handleTurnTaken(event) 
  {
    if (gamer == "user_x") 
    {
      if (event.target.innerText === 'x' || event.target.innerText === 'o') 
      {
        alert("not use again")
      } 
      else 
      {
        event.target.innerText = 'x';
        console.log(event)
        board.positions.forEach(el => el.removeEventListener('click', handleTurnTaken));
      }
    }
    else 
    {
      if (event.target.innerText === 'x' || event.target.innerText === 'o') 
      {
        alert("not use again")
      }
      else
      {
        event.target.innerText = 'o';
        event.target.disabled;
        board.positions.forEach(el => el.removeEventListener('click', handleTurnTaken));
      }
    }
  }
}


