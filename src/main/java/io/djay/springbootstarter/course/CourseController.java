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

import io.djay.springbootstarter.topic.Topic;

@RestController
@RequestMapping("/api/v1/topics")
@CrossOrigin("*")
public class CourseController {

	// Marked for DI
	@Autowired
	private CourseService courseService;

//	@RequestMapping("/courses")
	@GetMapping("/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}

//	@RequestMapping("/courses/{id}")
	@GetMapping("/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}

//	@RequestMapping(method = RequestMethod.POST, value = "/courses")
	@PostMapping("/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}

//	@RequestMapping(method = RequestMethod.PUT, value = "/courses/{id}")
	@PutMapping("/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}

//	@RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
	@DeleteMapping("/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
