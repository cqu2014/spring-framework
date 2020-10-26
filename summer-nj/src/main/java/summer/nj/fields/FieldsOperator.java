package summer.nj.fields;

import cn.hutool.core.lang.Console;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/10/26
 * @since
 */
public class FieldsOperator {
	public static void main(String[] args) {
		Field[] fields = Fox.class.getFields();
		show(fields);
		System.out.println("###############################################");
		Field[] declaredFields = Fox.class.getDeclaredFields();
		show(declaredFields);
        System.out.println("###############################################");
        allFields(Fox.class);
	}

	private static void show(Field[] declaredFields){
		for (Field field : declaredFields) {
			Console.log("{}=>{}",field.getName(),field.getType().getName());
		}
	}

    /**
     * 获取包含父类树在内的所有属性
     *
     * @param clazz
     */
	private static void allFields(Class<?> clazz){
       List<Field> allFields = new LinkedList<>();
       while (Objects.nonNull(clazz)){
           // 获取本类所有可见性属性
           Field[] declaredFields = clazz.getDeclaredFields();
           if (declaredFields.length > 0){
               allFields.addAll(Arrays.asList(declaredFields));
           }
           clazz = clazz.getSuperclass();
       }
       show(allFields.toArray(new Field[0]));
    }
}
