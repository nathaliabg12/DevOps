package com.example.dao;

import com.example.model.Student;
import com.example.util.MongoDBUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private MongoCollection<Document> collection;

    public StudentDAO() {
        this.collection = MongoDBUtil.getCollection();
    }

    public void insert(Student student) {
        Document doc = new Document()
                .append("_id", student.getSid())
                .append("username", student.getUsername())
                .append("email", student.getEmail())
                .append("year", student.getYear())
                .append("department", student.getDepartment());
        collection.insertOne(doc);
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        for (Document doc : collection.find()) {
            students.add(documentToStudent(doc));
        }
        return students;
    }

    public Student findById(String sid) {
        Document doc = collection.find(Filters.eq("_id", sid)).first();
        return doc != null ? documentToStudent(doc) : null;
    }

    public void update(Student student) {
        Bson filter = Filters.eq("_id", student.getSid());
        Document doc = new Document()
                .append("username", student.getUsername())
                .append("email", student.getEmail())
                .append("year", student.getYear())
                .append("department", student.getDepartment());
        collection.updateOne(filter, new Document("$set", doc));
    }

    public void delete(String sid) {
        collection.deleteOne(Filters.eq("_id", sid));
    }

    private Student documentToStudent(Document doc) {
        Student student = new Student();
        student.setSid(doc.getString("_id"));
        student.setUsername(doc.getString("username"));
        student.setEmail(doc.getString("email"));
        student.setYear(doc.getInteger("year"));
        student.setDepartment(doc.getString("department"));
        return student;
    }
}