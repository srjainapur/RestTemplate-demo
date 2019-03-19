package com.zensar.stdcourses.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zensar.stdcourses.model.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Long> {
	
	@Query(value="SELECT * FROM MIC_STD_COURSES WHERE STD_ID =:stdId", nativeQuery=true)
	public List<Courses> findCourseByStdId(@Param("stdId") Long stdId);

}
