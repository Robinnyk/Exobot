-- database: ../Database/EXOBOT.sqlite

PRAGMA foreign_keys = OFF;

DROP TABLE IF EXISTS trExoBot;

DROP TABLE IF EXISTS trPersona;

DROP TABLE IF EXISTS trCatalogo;

DROP TABLE IF EXISTS trCatalogoTipo;

DROP TABLE IF EXISTS trIABot;

DROP TABLE IF EXISTS trEnsamblado;

DROP TABLE IF EXISTS trPersonaTipo;

DROP TABLE IF EXISTS trSexo;

DROP TABLE IF EXISTS trArma;


CREATE TABLE trEnsamblado(
    trIdEnsamblado          INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    ,trIdIABot              INTEGER NOT NULL REFERENCES trIABot(trIdIABot)
    ,trIdExoBot             INTEGER NOT NULL REFERENCES trExoBot(trIdExoBot)
    ,trIdPersonaSoldado     INTEGER NOT NULL REFERENCES trPersona(trIdPersona)
    ,trIdPersonaMecatronico INTEGER NOT NULL REFERENCES trPersona(trIdPersona)
    ,trEstado        VARCHAR(1) NOT NULL DEFAULT('A')
    ,trFechaCreacion DATETIME DEFAULT(datetime('now', 'localtime'))
    ,trFechaModifica DATETIME
);


CREATE TABLE trCatalogoTipo (
    trIdCatalogoTipo INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    ,trNombre        VARCHAR(10) NOT NULL UNIQUE
    ,trDescripcion   VARCHAR(90) NOT NULL UNIQUE
    ,trEstado        VARCHAR(1) NOT NULL DEFAULT('A')
    ,trFechaCreacion DATETIME DEFAULT(datetime('now', 'localtime'))
    ,trFechaModifica DATETIME
);

CREATE TABLE trCatalogo (
    trIdCatalogo     INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    ,trIdCatalogoTipo INTEGER NOT NULL REFERENCES trCatalogoTipo(trIdCatalogoTipo)
    ,trNombre        VARCHAR(10) NOT NULL UNIQUE
    ,trDescripcion   VARCHAR(90) NOT NULL UNIQUE
    ,trEstado        VARCHAR(1) NOT NULL DEFAULT('A')
    ,trFechaCreacion DATETIME DEFAULT(datetime('now', 'localtime'))
    ,trFechaModifica DATETIME
);

CREATE TABLE trSexo(
    trIdSexo             INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    ,trIdCatalogo        INTEGER NOT NULL REFERENCES trCatalogo(trIdCatalogo)
    ,trIdCatalogoTipo    INTEGER NOT NULL REFERENCES trCatalogoTipo(trIdCatalogoTipo)
    ,trNombre            VARCHAR(10) NOT NULL UNIQUE
    ,trDescripcion       VARCHAR(90) NOT NULL UNIQUE
    ,trEstado            VARCHAR(1) NOT NULL UNIQUE
    ,trFechaCreacion     DATETIME DEFAULT(datetime('now', 'localtime'))
    ,trFechaModifica     DATETIME
);

CREATE TABLE trPersonaTipo( 
    trIdPersona           INTEGER NOT NULL REFERENCES trPersona(trIdPersona)
    ,trIdCatalogo          INTEGER NOT NULL REFERENCES trCatalogo(trIdCatalogo)
    ,trIdCatalogoTipo     INTEGER NOT NULL REFERENCES trCatalogoTipo(trIdCatalogoTipo)
    ,trNombre             VARCHAR(10) NOT NULL UNIQUE
    ,trDescripcion        VARCHAR(90) NOT NULL UNIQUE
    ,trEstado             VARCHAR(1) NOT NULL DEFAULT('A')            
    ,trFechaCreacion      DATETIME DEFAULT(datetime('now', 'localtime'))
    ,trFechaModifica      DATETIME
);

CREATE TABLE trIABot (
    trIdIABot       integer primary key AUTOINCREMENT
    ,trNombre       TEXT NOT NULL UNIQUE
    ,trObservacion  TEXT
    ,trEstado        VARCHAR(1) NOT NULL DEFAULT('A')
    ,trFechaCreacion DATETIME DEFAULT(datetime('now', 'localtime'))
    ,trFechaModifica DATETIME
);

CREATE TABLE trArma (
    trIdArma         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    ,trNombre        VARCHAR(50) NOT NULL UNIQUE
    ,trDescripcion   VARCHAR(90)
    ,trEstado        VARCHAR(1) NOT NULL DEFAULT('A')
    ,trFechaCreacion DATETIME DEFAULT(datetime('now', 'localtime'))
    ,trFechaModifica DATETIME
);

CREATE TABLE trExoBot (
    trIdExoBot       INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    ,trIdIABot       INTEGER NOT NULL 
    ,trIdArma        INTEGER REFERENCES trArma(trIdArma)
    ,trNombre        TEXT NOT NULL
    ,trSerie         TEXT NOT NULL
    ,trEntreno       VARCHAR(2) NOT NULL DEFAULT('NO')
    ,trInmovil       INTEGER NOT NULL DEFAULT 0
    ,trEstado        VARCHAR(1) NOT NULL DEFAULT('A')
    ,trFechaCreacion DATETIME DEFAULT(datetime('now', 'localtime'))
    ,trFechaModifica DATETIME
    ,CONSTRAINT      fk_trIABot      FOREIGN KEY(trIdIABot)   REFERENCES trIABot(trIdIABot)
    ,CONSTRAINT      fk_trArma       FOREIGN KEY(trIdArma)    REFERENCES trArma(trIdArma)
);

CREATE TABLE IF NOT EXISTS trPersona (
    trIdPersona INTEGER PRIMARY KEY AUTOINCREMENT,
    trIdCatalogoTipoPersona INTEGER NOT NULL,
    trIdCatalogoSexo INTEGER NOT NULL,
    trIdCatalogoEstadoCivil INTEGER NOT NULL,
    trCedula TEXT NOT NULL UNIQUE,
    trNombre TEXT NOT NULL,
    trApellido TEXT NOT NULL,

    FOREIGN KEY (trIdCatalogoTipoPersona) REFERENCES trCatalogo(trIdCatalogo),
    FOREIGN KEY (trIdCatalogoSexo) REFERENCES trCatalogo(trIdCatalogo),
    FOREIGN KEY (trIdCatalogoEstadoCivil) REFERENCES trCatalogo(IdtrCatalogo)
);
