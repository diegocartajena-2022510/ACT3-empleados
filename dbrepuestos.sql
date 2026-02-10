create database DBRpuestosAuto_in5cm;
use  DBRpuestosAuto_in5cm;

create table Proveedores(
	idProveedor int auto_increment not null,
    nombreProveedor varchar(60) not null,
    telefonoProveedor int not null,
    direccionProveedor varchar(100),
    emailProveedor varchar(100) not null,
    primary key PK_idProveedor (idProveedor)
);

create table Empleados(
	idEmpleado int auto_increment not null,
    nombreEmpleado varchar(60) not null,
    apellidoEmpleado varchar(60) not null,
    puestoEmpleado varchar(20) not null,
    emailEmpleado varchar(100) not null,
    primary key PK_idEmpleado(idEmpleado)
	
);


create table Repuestos(
	idRepuesto int auto_increment not null,
    nombreRepuesto varchar(60) not null,
    categoriaRepuesto varchar(60) not null,
    precioCompra double not null,
    precioVenta double not null,
    idProveedor int not null,
    primary key PK_idRepuesto(idRepuesto),
    constraint FK_repuestoProveedor foreign key (idProveedor)
    references Proveedores(idProveedor) on delete cascade

);

create table Ventas(
	idVenta int auto_increment not null,
	fechaVenta date not null,
	cantidad int not null,
	total double not null,
	idEmpleado int not null,
	idRepuesto int not null,
	primary key PK_id_venta(idVenta),
	constraint FK_ventas_empleado foreign key (idEmpleado)
	references Empleados(idEmpleado) on delete cascade,
    
	constraint FK_ventas_repuestos foreign key (idRepuesto)
	references Repuestos(idRepuesto) on delete cascade
);



	-- CREAR PROVEEDORES
	delimiter $$
	create procedure sp_crearProveedor(in p_nombreProveedor varchar(60), 
		in p_telefonoProveedor int, 
        in p_direccionProveedor varchar(100), 
        in p_emailProveedor varchar(100)
	) 
        
	begin 
		insert into proveedores(nombreProveedor,telefonoProveedor,direccionProveedor,emailProveedor) values
			(p_nombreProveedor, p_telefonoProveedor, p_direccionProveedor, p_emailProveedor);
	end $$
	delimiter ;	
    
    -- insertar 10 registros de proveedores 
    call sp_crearProveedor ('Repuestos El Amigo', 22334455, 'Zona 1, Ciudad de Guatemala', 'ventas@elamigo.com');
    call sp_crearProveedor ('Importadora Japonesa', 23445566, 'Calzada Roosevelt 12-45', 'info@japonesa.com.gt');
    call sp_crearProveedor ('Suministros Globales', 24556677, 'Avenida Las Américas 4-10', 'contacto@globales.com');
    call sp_crearProveedor ('Distribuidora Diesel', 25667788, 'Ruta Militar km 120', 'diesel_dist@gmail.com');
    call sp_crearProveedor ('Todo para su Motor', 26778899, 'Bulevar Liberación 8-20', 'ventas@motortodo.com');
    call sp_crearProveedor ('Frenos y Más', 27889900, 'Calle Martí 15-30', 'frenosymas@yahoo.com');
    call sp_crearProveedor ('Luces y Faros S.A.', 28990011, 'Zona 10, Edificio Pradera', 'luces@faros.com');
    call sp_crearProveedor ('Suspensiones Pro', 29001122, 'Cerca del Trébol', 'pro_suspension@pro.com');
    call sp_crearProveedor ('Accesorios Racing', 30112233, 'Plaza Inter, 2do Nivel', 'racing@accesorios.com');
    call sp_crearProveedor ('Radiadores El Rayo', 31223344, 'Km 15 Carretera al Salvador', 'elrayo@radiadores.com');
    
    -- LISTAR PROVEEDORES
    delimiter $$
	create procedure sp_listarproveedores()
	begin
		select * from proveedores;
	end $$
	delimiter ;
    
    -- EDITAR PROVEEDORES
    delimiter $$
	create procedure sp_editarproveedor(
		in p_idproveedor int, 
        in p_nombreproveedor varchar(60), 
        in p_telefonoproveedor int, 
        in p_direccionproveedor varchar(100), 
        in p_emailproveedor varchar(100)
	)
    
	begin
		update proveedores set 
			nombreproveedor = p_nombreproveedor, 
			telefonoproveedor = p_telefonoproveedor, 
			direccionproveedor = p_direccionproveedor, 
			emailproveedor = p_emailproveedor 
		where idproveedor = p_idproveedor;
	end $$
	delimiter ;
    
    -- ELIMINAR PROVEEDORES
    delimiter $$
	create procedure sp_eliminarproveedor(in p_idproveedor int)
	begin
		delete from proveedores where idproveedor = p_idproveedor;
	end $$
	delimiter ;
    
    
    
    -- CREAR EMPLEADOS
    delimiter $$
	create procedure sp_crearEmpleados(
		in p_nombreEmpleado varchar(60), 
        in p_apellidoEmpleado varchar(60), 
        in p_puestoEmpleado varchar(20),
		in p_emailEmpleado varchar(100)
        )
        begin
			insert into empleados(nombreEmpleado, apellidoEmpleado, puestoEmpleado, emailEmpleado) values
				(p_nombreEmpleado, p_apellidoEmpleado, p_puestoEmpleado, p_emailEmpleado);
        end $$
	delimiter ;
    
    -- insertar 10 registros de empleados
    call sp_crearEmpleados ('Carlos', 'Gómez', 'Vendedor', 'carlos.g@repuestos.com');
	call sp_crearEmpleados ('Ana', 'Martínez', 'Gerente', 'ana.m@repuestos.com');
	call sp_crearEmpleados ('Luis', 'Rodríguez', 'Vendedor', 'luis.r@repuestos.com');
	call sp_crearEmpleados ('Marta', 'López', 'Contadora', 'marta.l@repuestos.com');
	call sp_crearEmpleados ('José', 'Hernández', 'Bodeguero', 'jose.h@repuestos.com');
	call sp_crearEmpleados ('Sofía', 'Pérez', 'Vendedor', 'sofia.p@repuestos.com');
	call sp_crearEmpleados ('Jorge', 'García', 'Vendedor', 'jorge.g@repuestos.com');
	call sp_crearEmpleados ('Elena', 'Díaz', 'Recepcionista', 'elena.d@repuestos.com');
	call sp_crearEmpleados ('Pedro', 'Ramírez', 'Seguridad', 'pedro.r@repuestos.com');
	call sp_crearEmpleados ('Laura', 'Vásquez', 'Vendedor', 'laura.v@repuestos.com');
    
    -- LISTAR EMPLEADOS
    delimiter $$
	create procedure sp_listarempleados()
	begin
		select * from empleados;
	end $$
	delimiter ;empleados
    
    -- EDITAR EMPLEADOS
    delimiter $$
	create procedure sp_editarempleado(
		in p_idempleado int, 
        in p_nombreempleado varchar(60), 
        in p_apellidoempleado varchar(60), 
        in p_puestoempleado varchar(20), 
        in p_emailempleado varchar(100)
	)
    
	begin
		update empleados set 
			nombreempleado = p_nombreempleado, 
			apellidoempleado = p_apellidoempleado, 
			puestoempleado = p_puestoempleado, 
			emailempleado = p_emailempleado 
		where idempleado = p_idempleado;
	end $$
	delimiter ;
    
    -- ELIMINAR EMPLEADOS
    delimiter $$
	create procedure sp_eliminarempleado(in p_idempleado int)
	begin
		delete from empleados where idempleado = p_idempleado;
	end $$
	delimiter ;
    
    
    
    -- CREAR REPUESTOS
    delimiter $$
	create procedure sp_crearRepuestos(
		in p_nombreRepuesto varchar(60), 
		in p_categoriaRepuesto varchar(60), 
        in p_precioCompra double,
        in p_precioVenta double, 
        in p_idProveedor int
	)
	begin 
		insert into repuestos(nombreRepuesto,categoriaRepuesto,precioCompra,precioVenta,idProveedor) values
			( p_nombreRepuesto, p_categoriaRepuesto, p_precioCompra, p_precioVenta, p_idProveedor);
    end $$
	delimiter ;
    
    -- insertar 10 presupuesto
    call sp_crearRepuestos ('Pastillas de Freno', 'Frenos', 150.00, 225.00, 6);
    call sp_crearRepuestos ('Amortiguador Delantero', 'Suspensión', 400.00, 650.00, 8);
    call sp_crearRepuestos ('Filtro de Aceite', 'Motor', 25.00, 45.00, 5);
    call sp_crearRepuestos ('Bujía Iridium', 'Motor', 60.00, 95.00, 2);
    call sp_crearRepuestos ('Batería 12V', 'Eléctrico', 550.00, 800.00, 1);
    call sp_crearRepuestos ('Kit de Clutch', 'Transmisión', 1200.00, 1800.00, 3);
    call sp_crearRepuestos ('Bomba de Agua', 'Motor', 350.00, 500.00, 10);
    call sp_crearRepuestos ('Faro LED', 'Iluminación', 200.00, 350.00, 7);
    call sp_crearRepuestos ('Radiador', 'Enfriamiento', 800.00, 1100.00, 10);
    call sp_crearRepuestos ('Disco de Freno', 'Frenos', 300.00, 450.00, 6);
    
    -- LISTAR REPUESTOS
    delimiter $$
	create procedure sp_listarrepuestos()
	begin
		select * from repuestos;
	end $$
	delimiter ;
    
    -- EDITAR REPUESTOS
    delimiter $$
	create procedure sp_editarPrepuesto(
		in p_idrepuesto int, in p_nombrerepuesto varchar(60), 
        in p_categoriarepuesto varchar(60), 
        in p_preciocompra double, in p_precioventa double, 
        in p_idproveedor int
	)
    
	begin
		update repuestos set 
			nombrerepuesto = p_nombrerepuesto, 
			categoriarepuesto = p_categoriarepuesto, 
			preciocompra = p_preciocompra, 
			precioventa = p_precioventa, 
			idproveedor = p_idproveedor 
		where idrepuesto = p_idrepuesto;
	end $$
	delimiter ;
    
    -- ELIMINAR REPUESTOS
    delimiter $$
	create procedure sp_eliminarrepuesto(in p_idrepuesto int)
	begin
		delete from repuestos where idrepuesto = p_idrepuesto;
	end $$
	delimiter ;
    
    
    
    
    -- CREAR VENTAS	
    delimiter $$
	create procedure sp_crearVentas(
	in p_fechaventa date, 
	in p_cantidad int, 
    in p_total double, 
    in p_idempleado int, 
    in p_idrepuesto int
    ) 
	begin 
		insert into ventas(fechaventa, cantidad, total, idempleado, idrepuesto) 
        values (p_fechaventa, p_cantidad, p_total, p_idempleado, p_idrepuesto);
	end $$
delimiter ;

 -- insertar 10 ventas
	call sp_crearVentas ('2026-02-01', 2, 450.00, 1, 1);
	call sp_crearVentas ('2026-02-01', 4, 180.00, 3, 3);
	call sp_crearVentas ('2026-02-02', 1, 800.00, 6, 5);
	call sp_crearVentas ('2026-02-02', 2, 1300.00, 7, 2);
	call sp_crearVentas ('2026-02-03', 1, 1800.00, 10, 6);
	call sp_crearVentas ('2026-02-03', 4, 380.00, 1, 4);
	call sp_crearVentas ('2026-02-03', 2, 700.00, 3, 8);
	call sp_crearVentas ('2026-02-03', 1, 1100.00, 6, 9);
	call sp_crearVentas ('2026-02-03', 2, 900.00, 7, 10);
	call sp_crearVentas ('2026-02-03', 3, 135.00, 10, 3);
    
    -- LISTAR VENTAS
    delimiter $$
	create procedure sp_listarventas()
	begin
		select * from ventas;
	end $$
	delimiter ;
    
    -- EDITAR VENTAS
    delimiter $$
	create procedure sp_editarventa(
		in p_idventa int, in p_fechaventa date, 
		in p_cantidad int, in p_total double, 
		in p_idempleado int, in p_idrepuesto int
	)
    
	begin
		update ventas set 
			fechaventa = p_fechaventa, 
			cantidad = p_cantidad, 
			total = p_total, 
			idempleado = p_idempleado, 
			idrepuesto = p_idrepuesto 
		where idventa = p_idventa;
	end $$
	delimiter ;
    
    -- ELIMINAR VENTAS
    delimiter $$
	create procedure sp_eliminarventa(in p_idventa int)
	begin
		delete from ventas where idventa = p_idventa;
	end $$
	delimiter ;