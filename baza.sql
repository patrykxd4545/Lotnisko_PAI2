CREATE DATABASE `lotnisko` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;


-- lotnisko.crews definition

CREATE TABLE `crews` (
  `crew_id` int NOT NULL,
  `employee_id` int DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pesel` int DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`crew_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.employee definition

CREATE TABLE `employee` (
  `employee_id` int NOT NULL,
  `birthday` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.foods definition

CREATE TABLE `foods` (
  `food_id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`food_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.tickets definition

CREATE TABLE `tickets` (
  `ticket_id` bigint NOT NULL,
  `cost` double DEFAULT NULL,
  `flight_date` datetime(6) DEFAULT NULL,
  `seat_number` int DEFAULT NULL,
  PRIMARY KEY (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.baggage definition

CREATE TABLE `baggage` (
  `id` bigint NOT NULL,
  `bookingid` bigint NOT NULL,
  `ticket_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3r62i6h8wcwu82396ue4lwu4r` (`ticket_id`),
  CONSTRAINT `FK3r62i6h8wcwu82396ue4lwu4r` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.food_services definition

CREATE TABLE `food_services` (
  `service_id` bigint NOT NULL,
  `food_id` bigint DEFAULT NULL,
  PRIMARY KEY (`service_id`),
  KEY `FKp8ug2l475dejujirl0axu3siv` (`food_id`),
  CONSTRAINT `FKp8ug2l475dejujirl0axu3siv` FOREIGN KEY (`food_id`) REFERENCES `foods` (`food_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.orders definition

CREATE TABLE `orders` (
  `order_id` bigint NOT NULL,
  `service_id` bigint DEFAULT NULL,
  `ticket_id` bigint DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK2cxpir13pq9m6l716t1r0bt6i` (`service_id`),
  KEY `FK56s83c9boy7i8d9v4kf9a9979` (`ticket_id`),
  CONSTRAINT `FK2cxpir13pq9m6l716t1r0bt6i` FOREIGN KEY (`service_id`) REFERENCES `food_services` (`service_id`),
  CONSTRAINT `FK56s83c9boy7i8d9v4kf9a9979` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.payments definition

CREATE TABLE `payments` (
  `payment_id` int NOT NULL,
  `amount_payment` double DEFAULT NULL,
  `method_payment` varchar(255) DEFAULT NULL,
  `payment_date` datetime(6) DEFAULT NULL,
  `ticket_id` bigint DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `FKix2erkxpmt7dx3e8dhjnunm52` (`ticket_id`),
  CONSTRAINT `FKix2erkxpmt7dx3e8dhjnunm52` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.person definition

CREATE TABLE `person` (
  `id` bigint NOT NULL,
  `birthdate` datetime(6) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `nationality` varchar(255) NOT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjcfmws5i93dsb1yp3sxqupr52` (`employee_id`),
  CONSTRAINT `FKjcfmws5i93dsb1yp3sxqupr52` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.pilots definition

CREATE TABLE `pilots` (
  `pilot_id` int NOT NULL,
  `airlines_id` int DEFAULT NULL,
  `experience` int DEFAULT NULL,
  `passport_number` int DEFAULT NULL,
  `salary` int DEFAULT NULL,
  `crew_id` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`pilot_id`),
  KEY `FK5u0m55i7ffs90cl3nkpgt96cb` (`crew_id`),
  KEY `FK1r70i4lgnagk062oc3jxxcgeu` (`employee_id`),
  CONSTRAINT `FK1r70i4lgnagk062oc3jxxcgeu` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `FK5u0m55i7ffs90cl3nkpgt96cb` FOREIGN KEY (`crew_id`) REFERENCES `crews` (`crew_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.stewardessas definition

CREATE TABLE `stewardessas` (
  `stewardessa` int NOT NULL,
  `experience` int DEFAULT NULL,
  `passport_number` int DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `service_id` bigint DEFAULT NULL,
  `crew_id` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`stewardessa`),
  KEY `FKkmx3uqk3rtwcmciacgxcqlbud` (`service_id`),
  KEY `FKmssvq6eh1err8i79ehah0514p` (`crew_id`),
  KEY `FKdlmaul59b3uvnyvgab6ni2vfi` (`employee_id`),
  CONSTRAINT `FKdlmaul59b3uvnyvgab6ni2vfi` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `FKkmx3uqk3rtwcmciacgxcqlbud` FOREIGN KEY (`service_id`) REFERENCES `food_services` (`service_id`),
  CONSTRAINT `FKmssvq6eh1err8i79ehah0514p` FOREIGN KEY (`crew_id`) REFERENCES `crews` (`crew_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.forwarder definition

CREATE TABLE `forwarder` (
  `id` bigint NOT NULL,
  `emergencynumber` int NOT NULL,
  `passportnumber` varchar(255) NOT NULL,
  `salary` varchar(255) NOT NULL,
  `employee_id` int DEFAULT NULL,
  `personid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKre3duq6gwwy3bjsomxprlufje` (`employee_id`),
  KEY `FK925gr3nksecwc0dwbl0orwjo4` (`personid`),
  CONSTRAINT `FK925gr3nksecwc0dwbl0orwjo4` FOREIGN KEY (`personid`) REFERENCES `person` (`id`),
  CONSTRAINT `FKre3duq6gwwy3bjsomxprlufje` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.passangers definition

CREATE TABLE `passangers` (
  `passanger_id` bigint NOT NULL,
  `passportnumber` bigint NOT NULL,
  `phonenumber` bigint NOT NULL,
  `personid` bigint DEFAULT NULL,
  `ticket_id` bigint DEFAULT NULL,
  PRIMARY KEY (`passanger_id`),
  KEY `FK9ss3iplf56y43ud4k9r1qxqxj` (`personid`),
  KEY `FKimg4abikqtovk9d1h56qqahpj` (`ticket_id`),
  CONSTRAINT `FK9ss3iplf56y43ud4k9r1qxqxj` FOREIGN KEY (`personid`) REFERENCES `person` (`id`),
  CONSTRAINT `FKimg4abikqtovk9d1h56qqahpj` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.bookings definition

CREATE TABLE `bookings` (
  `id` bigint NOT NULL,
  `booking_date` varchar(255) DEFAULT NULL,
  `passanger_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1dv4ll3kjktn7mrdfps5smbnl` (`passanger_id`),
  CONSTRAINT `FK1dv4ll3kjktn7mrdfps5smbnl` FOREIGN KEY (`passanger_id`) REFERENCES `passangers` (`passanger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.customerfeedback definition

CREATE TABLE `customerfeedback` (
  `customerid` bigint NOT NULL,
  `date` datetime(6) NOT NULL,
  `description` varchar(255) NOT NULL,
  `bookingid` bigint DEFAULT NULL,
  `passanger_id` bigint DEFAULT NULL,
  PRIMARY KEY (`customerid`),
  KEY `FKe10o8admm9902ah8mey65o7vi` (`bookingid`),
  KEY `FKrn51wfkrbj4r3ad1fqbe8xlcx` (`passanger_id`),
  CONSTRAINT `FKe10o8admm9902ah8mey65o7vi` FOREIGN KEY (`bookingid`) REFERENCES `bookings` (`id`),
  CONSTRAINT `FKrn51wfkrbj4r3ad1fqbe8xlcx` FOREIGN KEY (`passanger_id`) REFERENCES `passangers` (`passanger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.arivvalairport definition

CREATE TABLE `arivvalairport` (
  `id` bigint NOT NULL,
  `address` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `depatureairportid` bigint DEFAULT NULL,
  `flight_id` int DEFAULT NULL,
  `forwarderid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKofw87wr8c1pjj44nnuq8sdcg1` (`depatureairportid`),
  KEY `FK81rh1ys87owsm5oo9jc2nf3d0` (`flight_id`),
  KEY `FKa2py7642fglos39d6rgbkq28o` (`forwarderid`),
  CONSTRAINT `FK81rh1ys87owsm5oo9jc2nf3d0` FOREIGN KEY (`flight_id`) REFERENCES `flights` (`flight_id`),
  CONSTRAINT `FKa2py7642fglos39d6rgbkq28o` FOREIGN KEY (`forwarderid`) REFERENCES `forwarder` (`id`),
  CONSTRAINT `FKofw87wr8c1pjj44nnuq8sdcg1` FOREIGN KEY (`depatureairportid`) REFERENCES `depatureairport` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.depatureairport definition

CREATE TABLE `depatureairport` (
  `id` bigint NOT NULL,
  `address` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `flight_id` int DEFAULT NULL,
  `forwarderid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkq50ykf1ffi1qg2nclmokfxwj` (`flight_id`),
  KEY `FKfegcn3wguebj1oqxg8s1ri66d` (`forwarderid`),
  CONSTRAINT `FKfegcn3wguebj1oqxg8s1ri66d` FOREIGN KEY (`forwarderid`) REFERENCES `forwarder` (`id`),
  CONSTRAINT `FKkq50ykf1ffi1qg2nclmokfxwj` FOREIGN KEY (`flight_id`) REFERENCES `flights` (`flight_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.flights definition

CREATE TABLE `flights` (
  `flight_id` int NOT NULL,
  `arrival_time` time DEFAULT NULL,
  `departure_time` time DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `crew_id` int DEFAULT NULL,
  `plane_id` bigint DEFAULT NULL,
  PRIMARY KEY (`flight_id`),
  KEY `FK9ms63v0lvfnc2jb15756m02wi` (`crew_id`),
  KEY `FKlyulbbnnff5cs3lmiluryaors` (`plane_id`),
  CONSTRAINT `FK9ms63v0lvfnc2jb15756m02wi` FOREIGN KEY (`crew_id`) REFERENCES `crews` (`crew_id`),
  CONSTRAINT `FKlyulbbnnff5cs3lmiluryaors` FOREIGN KEY (`plane_id`) REFERENCES `planes` (`plane_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- lotnisko.planes definition

CREATE TABLE `planes` (
  `plane_id` bigint NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `weight` bigint DEFAULT NULL,
  `crew_id` int DEFAULT NULL,
  `flight_id` int DEFAULT NULL,
  PRIMARY KEY (`plane_id`),
  KEY `FKmyc39qjfto2o8b52gen661i39` (`crew_id`),
  KEY `FKrrvqpse11i9wl5mtouv5w6mki` (`flight_id`),
  CONSTRAINT `FKmyc39qjfto2o8b52gen661i39` FOREIGN KEY (`crew_id`) REFERENCES `crews` (`crew_id`),
  CONSTRAINT `FKrrvqpse11i9wl5mtouv5w6mki` FOREIGN KEY (`flight_id`) REFERENCES `flights` (`flight_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;