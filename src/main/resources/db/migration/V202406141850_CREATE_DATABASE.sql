--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `bio` varchar(255) DEFAULT NULL,
  `is_email_verified` bit(1) NOT NULL,
  `id_proof` varchar(255) DEFAULT NULL,
  `is_locked` bit(1) NOT NULL,
  `profile_pic` varchar(255) DEFAULT NULL,
  `user_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_e4w4av1wrhanry7t6mxt42nou` (`user_id`),
  KEY `FKnjuop33mo69pd79ctplkck40n` (`user_id`),
  CONSTRAINT `FKnjuop33mo69pd79ctplkck40n` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `appearances`
--

DROP TABLE IF EXISTS `appearances`;
CREATE TABLE `appearances` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `border` enum('FULL','MINIMIZED') NOT NULL,
  `card` enum('BORDERED','SHADOW') NOT NULL,
  `color` enum('BLUE','AQUA','PURPLE','GREEN','CYAN','ORANGE') NOT NULL,
  `direction` enum('LTR','RTL') NOT NULL,
  `layout` enum('VERTICAL','HORIZONTAL') NOT NULL,
  `sizing` enum('BOXED','FULL') NOT NULL,
  `theme` enum('LIGHT','DARK') NOT NULL,
  `user_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpeds0xy2cls0f3l404hq10oe` (`user_id`),
  CONSTRAINT `FKpeds0xy2cls0f3l404hq10oe` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `cart_items`
--

DROP TABLE IF EXISTS `cart_items`;
CREATE TABLE `cart_items` (
  `item_type` varchar(31) NOT NULL,
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `quantity` int NOT NULL,
  `cart_id` binary(16) NOT NULL,
  `pack_id` binary(16) NOT NULL,
  `plan_id` binary(16) NOT NULL,
  `pass_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_cart_items_carts_id` (`cart_id`),
  KEY `FK_cart_items_packs_id` (`pack_id`),
  KEY `FK_cart_items_subscription_plans_id` (`plan_id`),
  KEY `FK_cart_items_tickets_id` (`pass_id`),
  CONSTRAINT `FK_cart_items_carts_id` FOREIGN KEY (`cart_id`) REFERENCES `carts` (`id`),
  CONSTRAINT `FK_cart_items_packs_id` FOREIGN KEY (`pack_id`) REFERENCES `tickets` (`id`),
  CONSTRAINT `FK_cart_items_subscription_plans_id` FOREIGN KEY (`plan_id`) REFERENCES `subscription_plans` (`id`),
  CONSTRAINT `FK_cart_items_tickets_id` FOREIGN KEY (`pass_id`) REFERENCES `tickets` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `carts`
--

DROP TABLE IF EXISTS `carts`;
CREATE TABLE `carts` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `currency_code` enum('XOF','USD','EUR') NOT NULL,
  `is_validated` bit(1) NOT NULL,
  `user_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_carts_users_id` (`user_id`),
  CONSTRAINT `FK_carts_users_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `deliveries`
--

DROP TABLE IF EXISTS `deliveries`;
CREATE TABLE `deliveries` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `currency` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `poster` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `user_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1r1x07reydsktcshj4yv4qxtd` (`user_id`),
  CONSTRAINT `FK1r1x07reydsktcshj4yv4qxtd` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
CREATE TABLE `events` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `end_date_time` datetime(6) DEFAULT NULL,
  `main_img` varchar(255) DEFAULT NULL,
  `secondary_img` varchar(255) DEFAULT NULL,
  `third_img` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `scope` varchar(255) NOT NULL,
  `start_date_time` datetime(6) DEFAULT NULL,
  `state` enum('PUBLISHED','LIVE','END','ABORT','POSTPONED','PENDING') DEFAULT NULL,
  `primary_vid` varchar(255) DEFAULT NULL,
  `secondary_vid` varchar(255) DEFAULT NULL,
  `third_vid` varchar(255) DEFAULT NULL,
  `place_id` binary(16) DEFAULT NULL,
  `user_id` binary(16) DEFAULT NULL,
  `events_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ox8m7slwnedk0mwei26co7xv` (`place_id`),
  KEY `FKat8p3s7yjcp57lny4udqvqncq` (`user_id`),
  KEY `FK2tujpw59o9bas383l1pqdowxx` (`events_id`),
  CONSTRAINT `FK2tujpw59o9bas383l1pqdowxx` FOREIGN KEY (`events_id`) REFERENCES `places` (`id`),
  CONSTRAINT `FK4ox8m7slwnedk0mwei26co7xv` FOREIGN KEY (`place_id`) REFERENCES `places` (`id`),
  CONSTRAINT `FKat8p3s7yjcp57lny4udqvqncq` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `functionalities`
--

DROP TABLE IF EXISTS `functionalities`;
CREATE TABLE `functionalities` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `description` text NOT NULL,
  `designation` varchar(255) NOT NULL,
  `type` enum('FREE','FREEMIUM','PREMIUM') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_46ylrei899vkgpb7gs5p4k1cf` (`designation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `functionality_use_histories`
--

DROP TABLE IF EXISTS `functionality_use_histories`;
CREATE TABLE `functionality_use_histories` (
  `functionality_id` binary(16) NOT NULL,
  `user_id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `count` int NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_use` datetime(6) NOT NULL,
  PRIMARY KEY (`functionality_id`,`user_id`),
  KEY `FK_functionality_use_histories_users_id` (`user_id`),
  CONSTRAINT `FK_functionality_use_histories_functionalities_id` FOREIGN KEY (`functionality_id`) REFERENCES `functionalities` (`id`),
  CONSTRAINT `FK_functionality_use_histories_users_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
CREATE TABLE `notifications` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `message` varchar(255) NOT NULL,
  `timestamp` datetime(6) NOT NULL,
  `user_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_notifications_users_id` (`user_id`),
  CONSTRAINT `FK_notifications_users_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `currency_code` enum('XOF','USD','EUR') NOT NULL,
  `total_cost` double NOT NULL,
  `cart_id` binary(16) NOT NULL,
  `user_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_orders_carts_id` (`cart_id`),
  KEY `FK_orders_users_id` (`user_id`),
  CONSTRAINT `FK_orders_carts_id` FOREIGN KEY (`cart_id`) REFERENCES `carts` (`id`),
  CONSTRAINT `FK_orders_users_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `packs_on_tickets`
--

DROP TABLE IF EXISTS `packs_on_tickets`;
CREATE TABLE `packs_on_tickets` (
  `pack_id` binary(16) NOT NULL,
  `ticket_id` binary(16) NOT NULL,
  KEY `FK_packs_on_tickets_tickets_id` (`ticket_id`),
  KEY `FK_packs_on_tickets_packs_id` (`pack_id`),
  CONSTRAINT `FK_packs_on_tickets_packs_id` FOREIGN KEY (`pack_id`) REFERENCES `tickets` (`id`),
  CONSTRAINT `FK_packs_on_tickets_tickets_id` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
CREATE TABLE `payments` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `amount` double NOT NULL,
  `currency_code` enum('XOF','USD','EUR') NOT NULL,
  `payment_service_provider` tinyint NOT NULL,
  `user_id` binary(16) NOT NULL,
  `order_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_payements_users_id` (`user_id`),
  KEY `FK_payements_orders_id` (`order_id`),
  CONSTRAINT `FK_payements_orders_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FK_payements_users_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `payments_chk_1` CHECK ((`payment_service_provider` between 0 and 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `places`
--

DROP TABLE IF EXISTS `places`;
CREATE TABLE `places` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `plans_on_functionalities`
--

DROP TABLE IF EXISTS `plans_on_functionalities`;
CREATE TABLE `plans_on_functionalities` (
  `plan_id` binary(16) NOT NULL,
  `functionality_id` binary(16) NOT NULL,
  KEY `FK_plans_on_functionalities_functionalities_id` (`functionality_id`),
  KEY `FK_plans_on_functionalities_subscriptions_plans_id` (`plan_id`),
  CONSTRAINT `FK_plans_on_functionalities_functionalities_id` FOREIGN KEY (`functionality_id`) REFERENCES `functionalities` (`id`),
  CONSTRAINT `FK_plans_on_functionalities_subscriptions_plans_id` FOREIGN KEY (`plan_id`) REFERENCES `subscription_plans` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `prestation_requests`
--

DROP TABLE IF EXISTS `prestation_requests`;
CREATE TABLE `prestation_requests` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `end_date_time` datetime(6) NOT NULL,
  `message` varchar(255) NOT NULL,
  `start_date_time` datetime(6) NOT NULL,
  `status` enum('PENDING','ACCEPTED','REJECTED','ABORT') NOT NULL,
  `delivery_id` binary(16) NOT NULL,
  `event_id` binary(16) NOT NULL,
  `receiver_id` binary(16) NOT NULL,
  `sender_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo27and6h6pilgedm4sn9meyal` (`delivery_id`),
  KEY `FK9jvdwoaesv9tqy3jhuf13toe6` (`event_id`),
  KEY `FKmvrhduilviu9vxauxv8a3fv05` (`receiver_id`),
  KEY `FKt0tws5qnvw79189k5palmot4q` (`sender_id`),
  CONSTRAINT `FK9jvdwoaesv9tqy3jhuf13toe6` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`),
  CONSTRAINT `FKmvrhduilviu9vxauxv8a3fv05` FOREIGN KEY (`receiver_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKo27and6h6pilgedm4sn9meyal` FOREIGN KEY (`delivery_id`) REFERENCES `deliveries` (`id`),
  CONSTRAINT `FKt0tws5qnvw79189k5palmot4q` FOREIGN KEY (`sender_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `prestations`
--

DROP TABLE IF EXISTS `prestations`;
CREATE TABLE `prestations` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date_time` datetime(6) NOT NULL,
  `start_date_time` datetime(6) NOT NULL,
  `delivery_id` binary(16) DEFAULT NULL,
  `delivery_user_id` binary(16) NOT NULL,
  `event_id` binary(16) DEFAULT NULL,
  `event_user_id` binary(16) NOT NULL,
  `prestations_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK64rqm1lmcove9v4mt985ufw1a` (`delivery_id`),
  KEY `FKcejxanpl41bi75ys34kx5qgrl` (`delivery_user_id`),
  KEY `FK92jqb67celci6cxojx351p134` (`event_id`),
  KEY `FKbfhlfkay1m6j7nlqst6tgg0au` (`event_user_id`),
  KEY `FKmjimgscfy0jem0xujmslaog1w` (`prestations_id`),
  CONSTRAINT `FK64rqm1lmcove9v4mt985ufw1a` FOREIGN KEY (`delivery_id`) REFERENCES `deliveries` (`id`),
  CONSTRAINT `FK92jqb67celci6cxojx351p134` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`),
  CONSTRAINT `FKbfhlfkay1m6j7nlqst6tgg0au` FOREIGN KEY (`event_user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKcejxanpl41bi75ys34kx5qgrl` FOREIGN KEY (`delivery_user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKmjimgscfy0jem0xujmslaog1w` FOREIGN KEY (`prestations_id`) REFERENCES `events` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `subscription_plans`
--

DROP TABLE IF EXISTS `subscription_plans`;
CREATE TABLE `subscription_plans` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `content` text NOT NULL,
  `is_available` bit(1) NOT NULL,
  `price` double NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qa1t0bmjg8anii671vr3eopji` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `subscriptions`
--

DROP TABLE IF EXISTS `subscriptions`;
CREATE TABLE `subscriptions` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `cost` double NOT NULL,
  `currency` tinyint NOT NULL,
  `duration` int NOT NULL,
  `end_date_time` datetime(6) NOT NULL,
  `start_date_time` datetime(6) NOT NULL,
  `plan_id` binary(16) NOT NULL,
  `user_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_subscriptions_subscriptions_plan_id` (`plan_id`),
  KEY `FK_subscriptions_users_id` (`user_id`),
  CONSTRAINT `FK_subscriptions_subscriptions_plan_id` FOREIGN KEY (`plan_id`) REFERENCES `subscription_plans` (`id`),
  CONSTRAINT `FK_subscriptions_users_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `subscriptions_chk_1` CHECK ((`currency` between 0 and 2))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
CREATE TABLE `tickets` (
  `dtype` varchar(31) NOT NULL,
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `currency` enum('XOF','USD','EUR') NOT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `pass_state` enum('UNAVAILABLE','AVAILABLE','OUT_OF_STOCK') NOT NULL,
  `pass_type` enum('SIMPLE','VIP','RESERVATION') NOT NULL,
  `price` double NOT NULL,
  `stock` int NOT NULL,
  `event_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qox6cwfs7bctcxnx5o0nj7a9i` (`logo`),
  KEY `FK_tickets_events_id` (`event_id`),
  CONSTRAINT `FK_tickets_events_id` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `version` bigint DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email_organisation` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `nom_organisation` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `provider` varchar(255) DEFAULT NULL,
  `siege` varchar(255) DEFAULT NULL,
  `site_web` varchar(255) DEFAULT NULL,
  `type` enum('ADMIN','STANDARD','ORGANIZER','SERVICES_PROVIDER','SPONSOR') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
  `user_id` binary(16) NOT NULL,
  `role_id` binary(16) NOT NULL,
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  KEY `FK2o0jvgh89lemvvo17cbqvdxaa` (`user_id`),
  CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;