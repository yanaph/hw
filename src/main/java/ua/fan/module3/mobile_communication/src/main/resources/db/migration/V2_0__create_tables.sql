create TABLE IF NOT EXISTS ActivityType(
    id VARCHAR(255) NOT NULL,
    typeName VARCHAR(255),
    CONSTRAINT pk_activityType PRIMARY KEY (id)
    );

create TABLE IF NOT EXISTS DeviceType(
    id VARCHAR(255) NOT NULL,
    typeName VARCHAR(255),
    CONSTRAINT pk_deviceType PRIMARY KEY (id)
    );

create TABLE IF NOT EXISTS Device(
    id VARCHAR(255) NOT NULL,
    modelName VARCHAR(255),
    deviceType_id VARCHAR(255),
    CONSTRAINT pk_device PRIMARY KEY (id)
    );

create TABLE IF NOT EXISTS Tariff (
    id VARCHAR(255) NOT NULL,
    tariffName VARCHAR(255),
    pricePerMonth FLOAT,
    CONSTRAINT pk_grade PRIMARY KEY (id)
    );

create TABLE IF NOT EXISTS Subscriber (
    id VARCHAR(255) NOT NULL,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    phoneNumber VARCHAR(255),
    tariff_id VARCHAR(255),
    device_id VARCHAR(255),
    CONSTRAINT pk_professor PRIMARY KEY (id)
    );

create TABLE IF NOT EXISTS Activity(
    id VARCHAR(255) NOT NULL,
    activityText VARCHAR(255),
    activityType_id VARCHAR(255),
    subscriber_id VARCHAR(255),
    CONSTRAINT pk_activity PRIMARY KEY (id)
    );

alter table Device add  CONSTRAINT FK_DEVICE_ON_TYPE FOREIGN KEY (deviceType_id) REFERENCES DeviceType (id);
alter table Subscriber add CONSTRAINT FK_SUBSCRIBER_ON_TARIFF FOREIGN KEY (tariff_id) REFERENCES Tariff (id);
alter table Subscriber add CONSTRAINT FK_SUBSCRIBER_ON_DEVICE FOREIGN KEY (device_id) REFERENCES Device (id);
alter table Activity add CONSTRAINT FK_ACTIVITY_ON_TYPE FOREIGN KEY (activityType_id) REFERENCES ActivityType (id);
alter table Activity add CONSTRAINT FK_ACTIVITY_ON_SUBSCRIBER FOREIGN KEY (subscriber_id) REFERENCES Subscriber (id);