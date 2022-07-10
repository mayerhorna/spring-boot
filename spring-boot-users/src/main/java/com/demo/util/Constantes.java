package com.demo.util;

public interface Constantes {
	
	String[] COUNTRIES = {"NONE", "India", "USA", "UK"};
	
	String[] SEX = {"Male", "Female"};
	
	String atributeNameMsgError = "msg_error";
	String atributeNameMsgOk = "msg_ok";
	String atributeNameMsgGeneral = "msg_general";
	int nroRegistrosXPagina = 3;
	//int nroRegistrosXPagina = 20;
	
	//para el motor de base de datos
	int DB_MYSQL = 1;
	int DB_ORACLE = 2;
	int DB_POSTGRES = 3;
	int DB_MSSQL = 4;
	
	//Para la paginacion
	String paginacion_atras = "P_ATRAS";
	String paginacion_siguiente = "P_SIGUIENTE";
	String paginacion_ultimo = "P_ULTIMO";
	String paginacion_primero = "P_PRIMERO";
	String paginacion_actualizar = "P_ACTUALIZAR";
	String paginacion_buscar = "P_BUSCAR";

}
