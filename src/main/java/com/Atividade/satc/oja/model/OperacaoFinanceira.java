package com.Atividade.satc.oja.model;

import java.time.LocalDate;

public interface OperacaoFinanceira {

    public LocalDate getDataOperacao();

    public Double getValorTotalOperacao();

    public TipoOperacao getTipoOperacao();


}
