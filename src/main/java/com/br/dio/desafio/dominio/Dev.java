package com.br.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosIncristos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosIncristos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsIncristos().add(this);
    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosIncristos.stream().findFirst();
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosIncristos.remove(conteudo.get());
        }else {
            System.err.println("Voçê não está inscrito em nenhum conteúdo!");
        }
    }

    public double calcularXp(){
        return  this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXP)
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosIncristos() {
        return conteudosIncristos;
    }

    public void setConteudosIncristos(Set<Conteudo> conteudosIncristos) {
        this.conteudosIncristos = conteudosIncristos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dev dev = (Dev) o;

        if (!Objects.equals(nome, dev.nome)) return false;
        if (!Objects.equals(conteudosIncristos, dev.conteudosIncristos))
            return false;
        return Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (conteudosIncristos != null ? conteudosIncristos.hashCode() : 0);
        result = 31 * result + (conteudosConcluidos != null ? conteudosConcluidos.hashCode() : 0);
        return result;
    }
}
