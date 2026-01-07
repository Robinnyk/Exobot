
    -- Database: ../Database/EXOBOT.sqlite


    DROP TABLE IF EXISTS trPersona;

    DROP TABLE IF EXISTS trExobot;

    DROP TABLE IF EXISTS trCatalogo;

    DROP TABLE IF EXISTS trCatalogoTipo;

    DROP TABLE IF EXISTS trIABot;


    CREATE TABLE trCatalogoTipo (
        trIdCatalogoTipo  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
        trNombre          VARCHAR(10) NOT NULL UNIQUE,
        trDescripcion     VARCHAR(90) NOT NULL UNIQUE,
        trEstado          VARCHAR(1) NOT NULL DEFAULT 'A',
        trFechaCreacion   DATETIME DEFAULT CURRENT_TIMESTAMP,
        trFechaModifica   DATETIME
    );

    CREATE TABLE trCatalogo (
        trIdCatalogo      INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
        trIdCatalogoTipo  INTEGER NOT NULL REFERENCES trCatalogoTipo(trIdCatalogoTipo),
        trNombre          VARCHAR(10) NOT NULL UNIQUE,
        trDescripcion     VARCHAR(90) NOT NULL UNIQUE,
        trEstado          VARCHAR(1) NOT NULL DEFAULT 'A',
        trFechaCreacion   DATETIME DEFAULT (datetime('now', 'localtime')),
        trFechaModifica   DATETIME
    );

    CREATE TABLE trIABot (
        trIdIABot         INTEGER PRIMARY KEY AUTOINCREMENT,
        trNombre          TEXT NOT NULL,
        trDescripcion     TEXT,
        trFechaCreacion   DATETIME DEFAULT CURRENT_TIMESTAMP
    );

    CREATE TABLE trExobot (
        trIdExobot        INTEGER PRIMARY KEY AUTOINCREMENT,
        trIdIABot         INTEGER NOT NULL,
        trNombre          TEXT NOT NULL,
        trSerie           TEXT NOT NULL,
        trDescripcion     TEXT, 
        CONSTRAINT        FK_trIABot
        FOREIGN KEY       (trIdIABot) 
        REFERENCES        trIABot(trIdIABot)
    );

    CREATE TABLE trPersona (
        trIdPersona                      INTEGER PRIMARY KEY AUTOINCREMENT,
        trIdCatalogoPersona              INTEGER NOT NULL REFERENCES trCatalogo(trIdCatalogoPersona),
        trIdCatalogoSexo                 INTEGER NOT NULL REFERENCES trCatalogo(trIdCatalogoSexo),
        trIdCatalogoEstadoCivil          INTEGER NOT NULL REFERENCES trCatalogo(trIdCatalogoEstadoCivil),
        trNombre                         VARCHAR(50) NOT NULL,
        trApellido                       VARCHAR(50) NOT NULL,
        trCedula                         VARCHAR(10) NOT NULL UNIQUE,

        trEstado                         VARCHAR(1) NOT NULL DEFAULT 'A',
        trFechaCreacion                  DATETIME DEFAULT (datetime('now', 'localtime')),
        trFechaModifica                  DATETIME
    );



    


