CREATE DATABASE `cen4010group24` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `author` (
  `id` int NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `biography` varchar(200) NOT NULL,
  `publisher` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `book` (
  `id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(200) NOT NULL,
  `price` decimal(8,0) NOT NULL,
  `author` int NOT NULL,
  `copies_sold` int NOT NULL,
  `publisher` varchar(45) NOT NULL,
  `isbn` varchar(45) NOT NULL,
  `year_published` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idbook_UNIQUE` (`id`),
  UNIQUE KEY `isbn_UNIQUE` (`isbn`),
  KEY `author_id_idx` (`author`),
  CONSTRAINT `author_id` FOREIGN KEY (`author`) REFERENCES `author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `comment` (
  `id` int NOT NULL,
  `user_id` int NOT NULL,
  `book_id` int NOT NULL,
  `comment` varchar(500) NOT NULL,
  `datestamp` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `book_comment_id_idx` (`book_id`),
  KEY `user_comment_id_idx` (`user_id`),
  CONSTRAINT `book_comment_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `user_comment_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `creditcard` (
  `id` int NOT NULL,
  `card_number` int unsigned NOT NULL,
  `security_code` int unsigned NOT NULL,
  `expiration` varchar(4) NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `card_number_UNIQUE` (`card_number`),
  UNIQUE KEY `idcreditcard_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `genre` (
  `id` int NOT NULL,
  `genre_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `genreitem` (
  `id` int NOT NULL,
  `book_id` int NOT NULL,
  `genre_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `book_id_idx` (`book_id`),
  KEY `genre_id_idx` (`genre_id`),
  CONSTRAINT `book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `genre_id` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `rating` (
  `id` int NOT NULL,
  `user_id` int NOT NULL,
  `book_id` int NOT NULL,
  `rating` int NOT NULL,
  `datestamp` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_rating_id_idx` (`user_id`),
  KEY `book_rating_id_idx` (`book_id`),
  CONSTRAINT `book_rating_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `user_rating_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `shoppingcartitem` (
  `id` int NOT NULL,
  `user_id` int NOT NULL,
  `book_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`),
  KEY `book_id_idx` (`book_id`),
  CONSTRAINT `book_shopping_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `user_shopping_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `home_address` varchar(45) DEFAULT NULL,
  `wishlist_count` int unsigned DEFAULT '0',
  `cc_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `cc_id_idx` (`cc_id`),
  CONSTRAINT `cc_id` FOREIGN KEY (`cc_id`) REFERENCES `creditcard` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `wishlist` (
  `id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `wishlistitem` (
  `id` int NOT NULL,
  `wishlist_id` int NOT NULL,
  `book_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `wishlist_id_idx` (`wishlist_id`),
  KEY `book__id_idx` (`book_id`),
  CONSTRAINT `book__id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `wishlist_id` FOREIGN KEY (`wishlist_id`) REFERENCES `wishlist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

