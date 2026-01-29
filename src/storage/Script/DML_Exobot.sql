-- database: ../Database/EXOBOT.sqlite

INSERT OR IGNORE INTO trCatalogoTipo
(trNombre, trDescripcion) VALUES 
('Tipo Persona'  , 'tipo sol, meca,.....')
,('Sexo'  , 'mascu, fem,.....')
,('Estado Civil'  , 'sol, casado, viudo,.....')
,('Raza'  , 'negro, blanco,.....');
SELECT * FROM trCatalogoTipo;


INSERT OR IGNORE INTO trCatalogo
( trIdCatalogoTipo,   trNombre,              trDescripcion) VALUES
(         1          ,'Soldado', 'Tipos de personas para el ejercito'     )  --1
,(        1         ,'Mecanico',  'Tipos de personas para el ejercito'    )  --2
,(        1         ,'Experto Ing', 'Tipos de personas para el ejercito'     ) --3
,(        1         ,'Experto Esp', 'Tipos de personas para el ejercito'     ) --4

,(        2          ,'Masculino',      'Tipos de sexualidad'     ) ---5
,(        2         ,'Femenino',        'Tipos de sexualidad'    )  -- 6
,(        2         ,'Hibrido',         'Tipos de sexualidad'     ) --7
,(        2         ,'Asexual',         'Tipos de sexualidad'     ) --8

,(        3          ,'Soltero',      'Tipos de estados civiles'     ) -- 9
,(        3         ,'Casado',        'Tipos de estados civiles'    )  --- 10
,(        3         ,'Divorciado',     'Tipos de estados civiles'     ) -- 11
,(        3         ,'Viudo',         'Tipos de estados civiles'     ) -- 12

,(        4          ,'Negro',               'Tipos de raza'     )
,(        4         ,'Blanco',               'Tipos de raza'    )
,(        4         ,'Mestizo',              'Tipos de raza'     )
,(        4         ,'Trigueño',              'Tipos de raza'     );
SELECT * FROM trCatalago;



insert into trIABot (trNombre, trObservacion)
values ("IA-RUSO" , "Inteligencia Artificial");


INSERT OR IGNORE INTO trArma (trNombre, trDescripcion) VALUES
('Fusil/Revolver', 'Arma de fuego para ExoAsalto - Munición'),
('GPS/Giroscopio', 'Sistema de navegación para ExoExplorador - Energía'),
('Misil/Mortero', 'Arma pesada para ExoInfanteria - Munición'),
('BioSensor/BioEscaner', 'Sensor biomédico para ExoMedico - Energía (Mi caso)'),
('Laser/Bayoneta', 'Arma láser y cuerpo a cuerpo para ExoComando - Munición');

SELECT * FROM trArma;


INSERT INTO trPersona
(trIdCatalogoTipoPersona, trIdCatalogoSexo, trIdCatalogoEstadoCivil, trCedula, trNombre, trApellido)
VALUES
(1, 5, 9,  '11111', 'pepe',     'martinez'),
(2, 5, 11, '22222', 'juan',     'molina'),
(3, 5, 10, '33333', 'pedro',    'gomez'),
(4, 5, 9,  '44444', 'pablo',    'narvaez'),
(1, 6, 12, '01010', 'imelda',   'alvarez'),
(2, 6, 10, '02020', 'michelle','rodriguez'),
(3, 6, 11, '03030', 'sofia',    'tapia'),
(4, 6, 9,  '04040', 'alejandra','espinoza');

SELECT * FROM trPersona;

SELECT COUNT(*) TotalReg
FROM trCatalogo
WHERE   Estado = 'A'
AND    trIdCatalogoTipo = 2;

