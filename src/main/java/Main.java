import com.br.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso java");
        curso1.setDescricao("Descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso js");
        curso2.setDescricao("Descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de java");
        mentoria.setDescricao("Descrição mentoria java");
        mentoria.setData(LocalDate.now());

//        System.out.println(curso1);
//        System.out.println(curso2);
//        System.out.println(mentoria);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devRaimison = new Dev();
        devRaimison.setNome("Raimison");
        devRaimison.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos incristos Raimison" + devRaimison.getConteudosIncristos());
        devRaimison.progredir();
        devRaimison.progredir();
        System.out.println("-");
        System.out.println("Conteúdos incristos Raimison" + devRaimison.getConteudosIncristos());
        System.out.println("Conteúdos concluídos Raimison" + devRaimison.getConteudosConcluidos());
        System.out.println("XP " + devRaimison.calcularXp());

        System.out.println("------------------------");

        Dev devCamila = new Dev();
        devRaimison.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos incristos Camila" + devCamila.getConteudosIncristos());
        devRaimison.progredir();
        System.out.println("-");
        System.out.println("Conteúdos incristos Camila" + devCamila.getConteudosIncristos());
        System.out.println("Conteúdos concluídos Camila" + devRaimison.getConteudosConcluidos());
        System.out.println("XP " + devCamila.calcularXp());

    }
}
