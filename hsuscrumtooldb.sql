-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 06, 2017 at 09:03 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hsuscrumtooldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `AccountID` int(11) NOT NULL,
  `Username` varchar(25) NOT NULL,
  `Password` varchar(25) NOT NULL,
  `FullName` varchar(50) NOT NULL,
  `MobilePhone` varchar(25) NOT NULL,
  `Email` varchar(25) NOT NULL,
  `ScrumRole` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`AccountID`, `Username`, `Password`, `FullName`, `MobilePhone`, `Email`, `ScrumRole`) VALUES
(1, 'productowner', '123456', 'Đỗ Hoàng Tuấn Anh', '01212123231', 'anh.dht3772@gmail.com', 'Product Owner'),
(2, 'scrummaster', '123456', 'Trần Thanh Liêm', '01655809085', 'liem.tt@gmail.com', 'Scrum Master'),
(3, 'dev1', '456789', 'Nguyễn Văn Tèo', '01212123456', 'teo.nv@gmail.com', 'Developer'),
(4, 'dev2', '987654', 'Nguyễn Văn Tí', '01212456789', 'ti.nv@gmail.com', 'Developer'),
(5, 'dev3', '123456', 'Minh Béo', '0123456789', 'beo.minh@gmail.com', 'Developer');

-- --------------------------------------------------------

--
-- Table structure for table `productbacklog`
--

CREATE TABLE `productbacklog` (
  `ProductBacklogID` int(11) NOT NULL,
  `StoryNo` int(11) NOT NULL,
  `ProjectID` int(11) NOT NULL,
  `UserStory` text NOT NULL,
  `Priority` int(11) NOT NULL,
  `ProductBacklogStatus` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `productbacklog`
--

INSERT INTO `productbacklog` (`ProductBacklogID`, `StoryNo`, `ProjectID`, `UserStory`, `Priority`, `ProductBacklogStatus`) VALUES
(1, 1, 1, 'As a client\r\nI want to View HomePage\r\nSo that I can see what is on the HomePage', 1, ''),
(2, 2, 1, 'As a client\r\nI want to View Product list\r\nSo that I can see what product in my list', 2, ''),
(3, 3, 1, 'As a client\r\nI want to View Product details\r\nSo that I can see details of Product', 3, ''),
(4, 4, 1, 'As a client \r\nI want to View Product Compare\r\nSo that I can compare between 2 or more products.', 1, ''),
(5, 5, 1, 'As I client \r\nI want to Manage Shopping Cart\r\nSo that I can Add, Increase, Decrease, Remove product from shopping cart', 2, ''),
(6, 6, 1, 'As I a client \r\nI want to registration\r\nSo that I can login into the web system', 3, ''),
(7, 7, 1, 'As a client\r\nI want to Chat with Sale\r\nSo that I can have support at any time', 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `ProjectID` int(11) NOT NULL,
  `ProjectName` varchar(25) NOT NULL,
  `Requirement` text NOT NULL,
  `StartDate` varchar(25) NOT NULL,
  `EstimateTime` int(11) NOT NULL,
  `EndDate` varchar(25) NOT NULL,
  `ProjectStatus` varchar(25) NOT NULL,
  `ProductOwnerID` int(11) NOT NULL,
  `ScrumMasterID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`ProjectID`, `ProjectName`, `Requirement`, `StartDate`, `EstimateTime`, `EndDate`, `ProjectStatus`, `ProductOwnerID`, `ScrumMasterID`) VALUES
(1, 'Hi-Tech', 'Công ty Hi-Tech là một công ty chuyên kinh doanh về các thiết bị điện tử và công nghệ thông tin trong nhiều năm nay và đã có một lượng khách hàng nhất định.\r\n\r\nĐể mở rộng hoạt động kinh doanh của mình, công ty mong muốn xây dựng một hệ thống thương mại điện tử nhằm mở rộng phạm vi kinh doanh trên mạng Internet. \r\n\r\nHệ thống mới phải đảm bảo cho khách hàng viếng thăm Website dễ dành lựa chọn các sản phẩm, các chính sách của công ty cũng như mua hàng. Việc thanh toán có thể được thực hiện qua mạng hoặc thanh toán trực tiếp. Khách hàng có thể nhận hàng tại cửa hàng hoặc công ty sẽ có dịch vụ chuyển hàng có phí cho khách hàng.\r\n\r\nNgoài ra, hệ thống cũng cần có phân hệ để đảm bảo cho công ty quản lý các hoạt động kinh doanh như số lượng hàng có trong kho, quản lý đơn đặt hàng, tình trạng giao hàng v.v…\r\n\r\nThông tin chi tiết các chức năng bạn có thể tham khảo thêm tại: http://www.bkc.vn/M/Home ', '01/10/2017', 150, '', 'To do', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `sprint`
--

CREATE TABLE `sprint` (
  `SprintID` int(11) NOT NULL,
  `ProjectID` int(11) NOT NULL,
  `SprintNo` int(11) NOT NULL,
  `StartDate` varchar(25) NOT NULL,
  `EndDate` varchar(25) NOT NULL,
  `Deadline` varchar(25) NOT NULL,
  `SprintStatus` varchar(25) NOT NULL,
  `SprintConclude` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sprint`
--

INSERT INTO `sprint` (`SprintID`, `ProjectID`, `SprintNo`, `StartDate`, `EndDate`, `Deadline`, `SprintStatus`, `SprintConclude`) VALUES
(1, 1, 1, '27/10/2017', '17/11/2017', '25/11/2017', 'To do', '');

-- --------------------------------------------------------

--
-- Table structure for table `sprintbacklog`
--

CREATE TABLE `sprintbacklog` (
  `SprintBacklogID` int(11) NOT NULL,
  `SprintBacklogNo` int(11) NOT NULL,
  `ProductBacklogID` int(11) NOT NULL,
  `SprintID` int(11) NOT NULL,
  `StartDate` varchar(25) NOT NULL,
  `EndDate` varchar(25) NOT NULL,
  `ActualStartDate` varchar(25) NOT NULL,
  `ActualEndDate` varchar(25) NOT NULL,
  `SprintBacklogStatus` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sprintbacklog`
--

INSERT INTO `sprintbacklog` (`SprintBacklogID`, `SprintBacklogNo`, `ProductBacklogID`, `SprintID`, `StartDate`, `EndDate`, `ActualStartDate`, `ActualEndDate`, `SprintBacklogStatus`) VALUES
(1, 1, 1, 1, '27/10/2017', '28/10/2017', '', '', 'To Do'),
(2, 2, 2, 1, '27/10/2017', '28/10/2017', '', '', 'To Do'),
(3, 3, 3, 1, '29/10/2017', '30/10/2017', '', '', 'To Do'),
(4, 4, 4, 1, '29/10/2017', '30/10/2017', '', '', 'To Do'),
(5, 5, 5, 1, '27/10/2017', '28/10/2017', '', '', 'To Do'),
(6, 6, 6, 1, '27/10/2017', '28/10/2017', '', '', 'To Do'),
(7, 7, 7, 1, '27/10/2017', '28/10/2017', '', '', 'To Do');

-- --------------------------------------------------------

--
-- Table structure for table `sprintevent`
--

CREATE TABLE `sprintevent` (
  `SprintEventID` int(11) NOT NULL,
  `SprintID` int(11) NOT NULL,
  `EventType` varchar(50) NOT NULL,
  `EventDate` varchar(25) NOT NULL,
  `Content` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sprintevent`
--

INSERT INTO `sprintevent` (`SprintEventID`, `SprintID`, `EventType`, `EventDate`, `Content`) VALUES
(1, 1, 'Stand Up Meeting', '25/10/2017', 'Please, get on time to make sure everybody understand clearly the requirement !');

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE `task` (
  `TaskID` int(11) NOT NULL,
  `TaskNo` int(11) NOT NULL,
  `SprintBacklogID` int(11) NOT NULL,
  `TaskDescription` text NOT NULL,
  `TaskStatus` varchar(50) NOT NULL,
  `DeveloperID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`TaskID`, `TaskNo`, `SprintBacklogID`, `TaskDescription`, `TaskStatus`, `DeveloperID`) VALUES
(1, 1, 1, 'Design & Code View for Homepage', 'To Do', 3),
(2, 2, 2, 'Design & Code View for Product List', 'To Do', 3),
(3, 3, 3, 'Design & Code View for Product Details', 'To Do', 4),
(4, 4, 4, 'Design & Code View for Product Compare', 'To Do', 4),
(5, 5, 5, 'Code Manage Shopping Cart', 'To Do', 4),
(6, 6, 6, 'Code Registration', '', 5),
(7, 7, 7, 'Code Chat with Sale', 'To Do', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`AccountID`);

--
-- Indexes for table `productbacklog`
--
ALTER TABLE `productbacklog`
  ADD PRIMARY KEY (`ProductBacklogID`),
  ADD KEY `ProjectID` (`ProjectID`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`ProjectID`),
  ADD KEY `ProductOwnerID` (`ProductOwnerID`),
  ADD KEY `ScrumMasterID` (`ScrumMasterID`);

--
-- Indexes for table `sprint`
--
ALTER TABLE `sprint`
  ADD PRIMARY KEY (`SprintID`),
  ADD KEY `ProjectID` (`ProjectID`);

--
-- Indexes for table `sprintbacklog`
--
ALTER TABLE `sprintbacklog`
  ADD PRIMARY KEY (`SprintBacklogID`),
  ADD KEY `ProductBacklogID` (`ProductBacklogID`),
  ADD KEY `SprintID` (`SprintID`);

--
-- Indexes for table `sprintevent`
--
ALTER TABLE `sprintevent`
  ADD PRIMARY KEY (`SprintEventID`),
  ADD KEY `SprintID` (`SprintID`);

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`TaskID`),
  ADD KEY `SprintBacklogID` (`SprintBacklogID`),
  ADD KEY `DeveloperID` (`DeveloperID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `AccountID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `productbacklog`
--
ALTER TABLE `productbacklog`
  MODIFY `ProductBacklogID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `ProjectID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `sprint`
--
ALTER TABLE `sprint`
  MODIFY `SprintID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `sprintbacklog`
--
ALTER TABLE `sprintbacklog`
  MODIFY `SprintBacklogID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `sprintevent`
--
ALTER TABLE `sprintevent`
  MODIFY `SprintEventID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `TaskID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `productbacklog`
--
ALTER TABLE `productbacklog`
  ADD CONSTRAINT `productbacklog_ibfk_1` FOREIGN KEY (`ProjectID`) REFERENCES `project` (`ProjectID`);

--
-- Constraints for table `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `project_ibfk_1` FOREIGN KEY (`ProductOwnerID`) REFERENCES `account` (`AccountID`),
  ADD CONSTRAINT `project_ibfk_2` FOREIGN KEY (`ScrumMasterID`) REFERENCES `account` (`AccountID`);

--
-- Constraints for table `sprint`
--
ALTER TABLE `sprint`
  ADD CONSTRAINT `sprint_ibfk_1` FOREIGN KEY (`ProjectID`) REFERENCES `project` (`ProjectID`);

--
-- Constraints for table `sprintbacklog`
--
ALTER TABLE `sprintbacklog`
  ADD CONSTRAINT `sprintbacklog_ibfk_1` FOREIGN KEY (`ProductBacklogID`) REFERENCES `productbacklog` (`ProductBacklogID`),
  ADD CONSTRAINT `sprintbacklog_ibfk_2` FOREIGN KEY (`SprintID`) REFERENCES `sprint` (`SprintID`);

--
-- Constraints for table `sprintevent`
--
ALTER TABLE `sprintevent`
  ADD CONSTRAINT `sprintevent_ibfk_1` FOREIGN KEY (`SprintID`) REFERENCES `sprint` (`SprintID`);

--
-- Constraints for table `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `task_ibfk_1` FOREIGN KEY (`SprintBacklogID`) REFERENCES `sprintbacklog` (`SprintBacklogID`),
  ADD CONSTRAINT `task_ibfk_2` FOREIGN KEY (`DeveloperID`) REFERENCES `account` (`AccountID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
