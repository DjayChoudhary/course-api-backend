package io.djay.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Business Service are typically singletons in spring framework When
 * application start ups, spring creates an instance of that service and keep
 * that in its memory which can access that instance object
 * 
 * @author Dell
 *
 */
@Service
public class CourseService {
	/**
	 * <p>
		╔═════════════════════╦═══════════════════════╗
		║      Old name       ║       New name        ║
		╠═════════════════════╬═══════════════════════╣
		║ findOne(…)          ║ findById(…)           ║
		╠═════════════════════╬═══════════════════════╣
		║ save(Iterable)      ║ saveAll(Iterable)     ║
		╠═════════════════════╬═══════════════════════╣
		║ findAll(Iterable)   ║ findAllById(…)        ║
		╠═════════════════════╬═══════════════════════╣
		║ delete(ID)          ║ deleteById(ID)        ║
		╠═════════════════════╬═══════════════════════╣
		║ delete(Iterable)    ║ deleteAll(Iterable)   ║
		╠═════════════════════╬═══════════════════════╣
		║ exists()            ║ existsById(…)         ║
		╚═════════════════════╩═══════════════════════╝
	 *</p>
	 */
	@Autowired
	private CourseRepository courseRepository;
	
//	private List<Course> courses = new ArrayList<>(
//			Arrays.asList(new Course("spring", "Spring Framework", "Spring Framework Description"),
//					new Course("java", "Core Java", "Core Java Description"),
//					new Course("javascript", "JavaScript", "JavaScript Description")));

	public List<Course> getAllCourses(String topicId) {
		// return courses;
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);	
		
		return courses;
	}

	public Course getCourse(String id) {
//		return courses.stream().filter(course -> course.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id).orElse(null);
		
	}

	public void addCourse(Course course) {
//		courses.add(course);
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
//		for (int i = 0; i < courses.size(); i++) {
//			if (courses.get(i).getId().equals(id)) {
//				courses.set(i, course);
//				return;
//			}
//		}
		
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
//		for (int i = 0; i < courses.size(); i++) {
//			if (courses.get(i).getId().equals(id)) {
//				courses.remove(i);
//				return;
//			}
//		}
		
//		courses.removeIf(course -> course.getId().equals(id));
		courseRepository.deleteById(id);
	}
}
