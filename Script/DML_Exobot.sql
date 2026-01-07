
INSERT INTO trCatalogoTipo (trNombre, trDescripcion) VALUES
( 'Tipo Persona'    , 'Tipos: soldado, mecanico, expertos, ...'),
( 'Sexo'            , 'Tipos: masculino, femenino, ...'),
( 'Estado Civil'    , 'Tipos: soltero, viudo, casado, ...'), 
( 'Raza'            , 'Tipos: negro, blanco, mestizo, ...');

INSERT INTO trCatalogo (trIdCatalogoTipo, trNombre, trDescripcion) VALUES
( 1,'Soldado', 'Tipo de persona del ejercito'),
( 1,'Mecanico', 'Tipo de persona del ejercito'),
( 1,'Experto Ing.', 'Tipo de persona del ejercito'),
( 1,'Experto Esp.', 'Tipo de persona del ejercito'),

( 2,'Masculino', 'Tipo de sexualidad'),
( 2,'Femenino', 'Tipo de sexualidad'),
( 2,'Hibrido', 'Tipo de sexualidad'),
( 2,'Asexual', 'Tipo de sexualidad'),

( 3,'Soltero', 'Tipo de estado civil Ecuador'),
( 3,'Casado', 'Tipo de estado civil Ecuador'),
( 3,'Viudo', 'Tipo de estado civil Ecuador'),
( 3,'Divorciado', 'Tipo de estado civil Ecuador'),

( 4,'Negro', 'Tipo de raza'),
( 4,'Blanco', 'Tipo de raza'),
( 4,'Mestizo', 'Tipo de raza'),
( 4,'Otro', 'Tipo de raza'),