package com.mycompany.atividade.web1.pp.fabricas;

public class DaoFactory {
    public static DaoFactoryIF creatFactory(){
        return new DaoFactoryBD();
    }
}
