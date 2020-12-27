CREATE TABLE `masterbank` (
  `id` int NOT NULL,
  `questionType` text NOT NULL,
  `question` text NOT NULL,
  `choices` varchar(1000) DEFAULT NULL,
  `correctAnswer` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `student` (
  `studentID` int NOT NULL,
  `name` text NOT NULL,
  `recitationNum` int NOT NULL,
  `netID` text NOT NULL,
  `password` text NOT NULL,
  PRIMARY KEY (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `test` (
  `studentID` int NOT NULL,
  `questionID` int NOT NULL,
  `answer` text NOT NULL,
  PRIMARY KEY (`questionID`,`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
