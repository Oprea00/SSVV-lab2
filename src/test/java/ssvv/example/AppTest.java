package ssvv.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import domain.Nota;
import domain.Student;
import domain.Tema;
import repository.*;

import org.junit.Test;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

/**
 * Unit test for simple App.
 */
public class AppTest 
{


    /**
     * Rigorous Test :-)
     */
    @Test
    public void addValidStudent()
    {
        Validator<Student> validator = new StudentValidator();
        Validator<Tema> validator1 = new TemaValidator();
        Validator<Nota> validator2 = new NotaValidator();
        StudentXMLRepository studentFileRepository = new StudentXMLRepository( validator,"studentiTest.xml");
        TemaXMLRepository temaFileRepository = new TemaXMLRepository(validator1, "teme.xml");
        NotaXMLRepository notaFileRepository = new NotaXMLRepository(validator2, "note.xml");

        Service service = new Service(studentFileRepository, temaFileRepository, notaFileRepository);

        assertEquals(service.saveStudent("10", "aaa", 935), 0);

    }

    @Test
    public void addInvalidStudent()
    {
        Validator<Student> validator = new StudentValidator();
        Validator<Tema> validator1 = new TemaValidator();
        Validator<Nota> validator2 = new NotaValidator();
        StudentXMLRepository studentFileRepository = new StudentXMLRepository( validator,"studentiTest.xml");
        TemaXMLRepository temaFileRepository = new TemaXMLRepository(validator1, "teme.xml");
        NotaXMLRepository notaFileRepository = new NotaXMLRepository(validator2, "note.xml");

        Service service = new Service(studentFileRepository, temaFileRepository, notaFileRepository);

        assertEquals(service.saveStudent("7", "invalid", 7), 1);

    }
}
