-- Create the database
CREATE DATABASE whoami;

-- Use the database
USE whoami;

-- Create the Account table
CREATE TABLE Account (
    account_id INT PRIMARY KEY,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(20) NOT NULL,
    age INT,
    gender ENUM('man', 'woman') DEFAULT 'man',
    games_played INT DEFAULT 0,
    victories INT DEFAULT 0
);
-- Create the Grid table
CREATE TABLE Grid (
    grid_id INT PRIMARY KEY,
    grid_name VARCHAR(30) NOT NULL,
    grid_size INT NOT NULL,
    random BOOLEAN NOT NULL
);

-- Create the Game table
CREATE TABLE Game (
    game_id INT PRIMARY KEY,
    game_password VARCHAR(20) NOT NULL,
    creator_id INT,
    opponent_id INT,
    rounds_count INT,
    turn_limit INT,
    grid_id INT,
    spectator BOOLEAN,
    game_date DATETIME,
    CONSTRAINT fk_Game_creator FOREIGN KEY (creator_id) REFERENCES Account(account_id),
    CONSTRAINT fk_Game_opponent FOREIGN KEY (opponent_id) REFERENCES Account(account_id),
    CONSTRAINT fk_Game_grid FOREIGN KEY (grid_id) REFERENCES Grid(grid_id)
);

-- Create the GameHistory table
CREATE TABLE GameHistory (
    game_id INT,
    player1_id INT,
    player2_id INT,
    player1_score INT,
    player2_score INT,
    winner INT,
    CONSTRAINT fk_GameHistory_game FOREIGN KEY (game_id) REFERENCES Game(game_id),
    CONSTRAINT fk_GameHistory_player1 FOREIGN KEY (player1_id) REFERENCES Account(account_id),
    CONSTRAINT fk_GameHistory_player2 FOREIGN KEY (player2_id) REFERENCES Account(account_id)
);

-- Create the Round table
CREATE TABLE Round (
    round_id INT PRIMARY KEY,
    game_id INT,
    round_number INT,
    winner_id INT,
    CONSTRAINT fk_Round_game FOREIGN KEY (game_id) REFERENCES Game(game_id),
    CONSTRAINT fk_Round_winner FOREIGN KEY (winner_id) REFERENCES Account(account_id)
);

-- Create the Character table
CREATE TABLE Character (
    character_id INT PRIMARY KEY,
    character_name VARCHAR(10) NOT NULL,
    image_url VARCHAR(50) NOT NULL
);

-- Create the junction table GridCharacter
CREATE TABLE GridCharacter (
    grid_id INT,
    character_id INT,
    PRIMARY KEY (grid_id, character_id),
    CONSTRAINT fk_GridCharacter_grid FOREIGN KEY (grid_id) REFERENCES Grid(grid_id),
    CONSTRAINT fk_GridCharacter_character FOREIGN KEY (character_id) REFERENCES Character(character_id)
);
