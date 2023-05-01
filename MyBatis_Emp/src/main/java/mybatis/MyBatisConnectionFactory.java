package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {

	// SqlSession객체를 생성하기 위한 팩토리 객체
	private static SqlSessionFactory sqlSessionFactory;

	// 정적 초기화 블록
	static {

		// 마이바티tm Configuration XML 파일의 경로
		String res = "mybatis/mybatis-config.xml";

		try {
			// Configuration XML파일을 이용하여 문자 입력 스트림 생성
			Reader reader = Resources.getResourceAsReader(res);

			if (sqlSessionFactory == null) {

				// 입력 스트림으로 읽어들인 설정파일을 이용하여
				// SqlSessionFactory객체를 생성한다
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// private생성자
	private MyBatisConnectionFactory() {

	}

	// 싱글톤 객체 반환 메소드
	public static SqlSessionFactory getSqlSeesionFactory() {
		return sqlSessionFactory;
	}

}
