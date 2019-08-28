package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class employController {


        private List<employee> list = new ArrayList<employee>() {{
            add(new employee(1, "老一", 21, "Male"));
            add(new employee(2, "老二", 21, "Female"));
            add(new employee(3, "老三", 21, "Male"));
            add(new employee(4, "老四", 21, "Female"));
            add(new employee(5, "老五", 21, "Male"));
            add(new employee(6, "老五", 21, "Female"));
        }};

        @GetMapping("/{id}")
        public ResponseEntity<employee> getEmployID(@PathVariable int id) {

            List<employee> list = new ArrayList<>();
            employee employee1 = new employee();
            employee employee = new employee();

            employee.setId(1);
            employee.setName("老六");
            employee.setAge(18);
            employee.setSex("man");
            list.add(employee);

            employee1.setId(2);
            employee1.setName("老五");
            employee1.setAge(18);
            employee1.setSex("woman");
            list.add(employee);

            for (employee a : list)
                if (id == employee.getId()) {
                    employee1 = a;
                }
            return ResponseEntity.ok(employee1);
        }

        @GetMapping("/name")
        public ResponseEntity<List<employee>> getEmployeeByNmae(@RequestParam("name") String name) {
            List<employee> list = new ArrayList<>();
            employee employee1 = new employee();
            employee employee = new employee();

            employee.setId(1);
            employee.setName("老六");
            employee.setAge(18);
            employee.setSex("man");
            list.add(employee);

            employee1.setId(2);
            employee1.setName("老五");
            employee1.setAge(18);
            employee1.setSex("woman");
            list.add(employee1);

            List<employee> retList = new ArrayList<>();
            for (employee e : list) {

                if (e.getName().indexOf(name) != -1) {
                    retList.add(e);
                }
            }
            return ResponseEntity.ok(retList);
        }

        @PostMapping()
        public ResponseEntity<List<employee>> addEmployee(@RequestBody employee employee) {
            list.add(employee);
            return ResponseEntity.ok(list);
        }


}

