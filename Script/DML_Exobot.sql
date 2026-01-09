-- database: ../Database/EXOBOT.sqlite

INSERT INTO trCatalogoTipo (trNombre, trDescripcion) VALUES
( 'Tipo Persona'    , 'Tipos: soldado, mecanico, expertos, ...'),
( 'Sexo'            , 'Tipos: masculino, femenino, ...'),
( 'Estado Civil'    , 'Tipos: soltero, viudo, casado, ...'), 
( 'Raza'            , 'Tipos: negro, blanco, mestizo, ...');

INSERT INTO trCatalogo (trIdCatalogoTipo, trNombre, trDescripcion) VALUES
( 1                 ,'Soldado', 'Tipo de persona del ejercito'),                -- 1
( 1                 ,'Mecanico', 'Tipo de persona del ejercito'),               -- 2
( 1                 ,'Experto Ing.', 'Tipo de persona del ejercito'),           -- 3
( 1                 ,'Experto Esp.', 'Tipo de persona del ejercito'),           -- 4

( 2                 ,'Masculino', 'Tipo de sexualidad'),                        -- 5
( 2                 ,'Femenino', 'Tipo de sexualidad'),                         -- 6
( 2                 ,'Hibrido', 'Tipo de sexualidad'),                          -- 7
( 2                 ,'Asexual', 'Tipo de sexualidad'),                          -- 8 

( 3                 ,'Soltero', 'Tipo de estado civil Ecuador'),                -- 9
( 3                 ,'Casado', 'Tipo de estado civil Ecuador'),                 -- 10
( 3                 ,'Viudo', 'Tipo de estado civil Ecuador'),                  -- 11
( 3                 ,'Divorciado', 'Tipo de estado civil Ecuador'),             -- 12

( 4                 ,'Negro', 'Tipo de raza'),                                  
( 4                 ,'Blanco', 'Tipo de raza'),
( 4                 ,'Mestizo', 'Tipo de raza'),
( 4                 ,'Otro', 'Tipo de raza');   

INSERT INTO trIABot (trNombre,trDescripcion) VALUES
( "IA_RUSO"         , "Inteligencia Artificial");

INSERT INTO trExobot (trIdIAbot, trNombre, trSerie) VALUES
( 1                 , "Exobot_001", "Serie E1"),
( 1                 , "Exobot_002", "Serie E2"),
( 1                 , "Exobot_003", "Serie E3");

INSERT INTO trPersona 
(trIdCatalogoPersona, trIdCatalogoSexo, trIdCatalogoEstadoCivil, trNombre, trApellido, trCedula) VALUES
(1,                   5,                    9,                    'Juan',   'Pérez',   '1234567890'),
(2,                   5,                    10,                   'María',  'Gómez',   '0987654321'),
(3,                   5,                    11,                   'Carlos', 'Ramírez', '1122334455'),
(4,                   5,                    12,                   'Ana',    'López',   '5566778899'),
(1,                   6,                    9,                    'Pepito',   'Putin',   '9998887776'),
(2,                   6,                    10,                   'Giuliana',  'Torres',   '1654321098'),
(3,                   6,                    11,                   'Eva', 'Reyes', '1567434455'),
(4,                   6,                    12,                   'Perla',    'Villa',   '1366778899');

SELECT trIdCatalogo
, trIdCatalogoTipo
, trNombre
, trDescripcion
, trEstado
, trFechaCreacion
, trFechaModifica
FROM trCatalogo
WHERE trEstado = 'A'
AND trIdCatalogoTipo = 2;

SELECT COUNT(*) TotalReg 
FROM trCatalogo 
WHERE trIdCatalogoTipo = 2 
AND trEstado = 'A';