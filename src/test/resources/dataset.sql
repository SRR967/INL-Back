INSERT INTO usuario (cedula, email, contrasena) VALUES
    ('1234567890', 'cliente1@example.com', 'usuario'),
    ('0987654321', 'cliente2@example.com', 'usuario'),
    ('12137792', 'cliente3@example.com', 'usuario'),
    ('1080367852', 'jesuss.ramonr@uqvirtual.edu.co', 'usuario');

INSERT INTO cliente (cedula, nombre, apellido, telefono) VALUES
    ('1234567890', 'Juan', 'Pérez', '0987654321'),
    ('0987654321', 'Ana', 'Gómez', '1234567890');

INSERT INTO empleado (id_empleado, nombre, apellido, cargo, cedula) VALUES
    ('1', 'Carlos', 'Ramirez', 0,'12137792'),
    ('2', 'Laura', 'Martinez', 1, '1080367852');

INSERT INTO solicitud (id_solicitud, fecha, descripcion, detalle, cliente_cedula, estado_solicitud) VALUES
    (1, '2024-05-01', 'Solicitud importante', 'Detalles de la solicitud', '1234567890', 2),
    (2, '2024-05-02', 'Solicitud de soporte', 'Detalles de soporte', '0987654321', 1);

INSERT INTO respuesta (mensaje, solicitud_id_solicitud, id_empleado) VALUES
    ('Respuesta a la solicitud 1', 2, '12137792');

INSERT INTO proyecto (id_proyecto, nombre, descripcion, fecha_inicio, fecha_fin, estado_proyecto,
                      id_solicitud_id_solicitud, id_empleado) VALUES
    (1, 'Proyecto A', 'Desarrollo de aplicación', '2024-01-01', '2024-12-31', 1, 2, '12137792');




