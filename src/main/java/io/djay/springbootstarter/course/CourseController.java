package io.djay.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/courses")
@CrossOrigin("*")
public class CourseController {

	// Marked for DI
	@Autowired
	private CourseService courseService;

//	@RequestMapping("/courses")
    @GetMapping
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}

//	@RequestMapping("/courses/{id}")
    @GetMapping("/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}

//	@RequestMapping(method = RequestMethod.POST, value = "/courses")
    @PostMapping
    public void addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
	}

//	@RequestMapping(method = RequestMethod.PUT, value = "/courses/{id}")
    @PutMapping("/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String id) {
		courseService.updateCourse(id, course);
	}
	
//	@RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
    @DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
