
CREATE TABLE IF NOT EXISTS entrenador (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fecha_nacimiento VARCHAR(255) NOT NULL,
    nacionalidad VARCHAR(255) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    edad INT NOT NULL
);

CREATE TABLE IF NOT EXISTS pokemon (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    especie VARCHAR(255) NOT NULL,
    vida FLOAT NOT NULL,
    poder INT NOT NULL,
    entrenador_id BIGINT,
    FOREIGN KEY (entrenador_id) REFERENCES entrenador(id)
);

INSERT INTO entrenador (nombre, fecha_nacimiento, nacionalidad, genero, edad)
VALUES ('Ash Ketchum', '1990-05-22', 'Kanto', 'Masculino', 34);

INSERT INTO pokemon (tipo, especie, vida, poder, entrenador_id)
VALUES ('Eléctrico', 'Pikachu', 100.0, 80, 1);

INSERT INTO pokemon (tipo, especie, vida, poder, entrenador_id)
VALUES ('Fuego', 'Charmander', 90.0, 75, 1);

INSERT INTO entrenador (nombre, fecha_nacimiento, nacionalidad, genero, edad)
VALUES ('Misty', '1992-08-06', 'Cerulean', 'Femenino', 32);

INSERT INTO pokemon (tipo, especie, vida, poder, entrenador_id)
VALUES ('Agua', 'Psyduck', 95.0, 70, 2);


