-- Create the database
CREATE DATABASE whoami;

-- Use the database
USE whoami;

-- Create the Account table
-- Create the Account table
CREATE TABLE Account (
    account_id NUMBER,
    username VARCHAR2(30) NOT NULL,
    age NUMBER,
    gender VARCHAR2(6) DEFAULT 'man',
    game_played NUMBER DEFAULT 0,
    victories NUMBER DEFAULT 0,
    CONSTRAINT pk_Account PRIMARY KEY (account_id),
    CONSTRAINT chk_gender CHECK (gender IN ('man', 'woman'))
);

-- Create the Grid table
CREATE TABLE Grid (
    grid_id NUMBER,
    grid_name VARCHAR(30) NOT NULL,
    grid_size NUMBER NOT NULL,
    random BOOLEAN NOT NULL,
    CONSTRAINT pk_Grid PRIMARY KEY (grid_id)
);

-- Create the Game table
CREATE TABLE Game (
    game_id NUMBER,
    game_password VARCHAR(20) NOT NULL,
    host_id NUMBER,
    guest_id NUMBER,
    number_of_rounds NUMBER,
    turn_limit NUMBER,
    grid_id NUMBER,
    spectator BOOLEAN,
    game_date DATETIME,
    CONSTRAINT pk_Game PRIMARY KEY (game_id),
    CONSTRAINT fk_Game_creator FOREIGN KEY (creator_id) REFERENCES Account(account_id),
    CONSTRAINT fk_Game_opponent FOREIGN KEY (opponent_id) REFERENCES Account(account_id),
    CONSTRAINT fk_Game_grid FOREIGN KEY (grid_id) REFERENCES Grid(grid_id)
);

-- Create the GameHistory table
CREATE TABLE GameHistory (
    game_id NUMBER,
    player1_id NUMBER,
    player2_id NUMBER,
    player1_score NUMBER,
    player2_score NUMBER,
    winner_id NUMBER,
    CONSTRAINT pk_GameHistory PRIMARY KEY (game_id),
    CONSTRAINT fk_GameHistory_game FOREIGN KEY (game_id) REFERENCES Game(game_id),
    CONSTRAINT fk_GameHistory_player1 FOREIGN KEY (player1_id) REFERENCES Account(account_id),
    CONSTRAINT fk_GameHistory_player2 FOREIGN KEY (player2_id) REFERENCES Account(account_id)
);

-- Create the Round table
CREATE TABLE Round (
    round_id NUMBER,
    game_id NUMBER,
    round_number NUMBER,
    winner_id NUMBER,
    CONSTRAINT pk_Round PRIMARY KEY (round_id),
    CONSTRAINT fk_Round_game FOREIGN KEY (game_id) REFERENCES Game(game_id),
    CONSTRAINT fk_Round_winner FOREIGN KEY (winner_id) REFERENCES Account(account_id)
);

-- Create the Character table
CREATE TABLE Character (
    character_id NUMBER,
    character_name VARCHAR(10) NOT NULL,
    url_image VARCHAR(50) NOT NULL,
    CONSTRAINT pk_Character PRIMARY KEY (character_id)
);

-- Create the junction table GridCharacter
CREATE TABLE GridCharacter (
    grid_id NUMBER,
    character_id NUMBER,
    CONSTRAINT pk_GridCharacter PRIMARY KEY (grid_id, character_id),
    CONSTRAINT fk_GridCharacter_grid FOREIGN KEY (grid_id) REFERENCES Grid(grid_id),
    CONSTRAINT fk_GridCharacter_character FOREIGN KEY (character_id) REFERENCES Character(character_id)
);

-- Drop the junction table GridCharacter
DROP TABLE GridCharacter;

-- Drop the Character table
DROP TABLE Character;

-- Drop the Round table
DROP TABLE Round;

-- Drop the GameHistory table
DROP TABLE GameHistory;

-- Drop the Game table
DROP TABLE Game;

-- Drop the Grid table
DROP TABLE Grid;

-- Drop the Account table
DROP TABLE Account;
