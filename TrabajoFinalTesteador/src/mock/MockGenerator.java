package mock;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import domain.Mock;
import domain.MockStringAttribute;
import domain.MockTodayAttribute;

@Mock()
public class MockGenerator {
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> List<T> createMockInstances(Class<T> elClass, int cant){ 
	
		List notifications = new ArrayList<T>();
		for (int i = 0; i < cant; i++) {
			try {
				Object newObject= createInstance(elClass);
				notifications.add(newObject);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return (List<T>) notifications;
	}
	
	@SuppressWarnings("rawtypes")
	private static Object createInstance(Class objectClass) throws InstantiationException, IllegalAccessException{
		Object instance = objectClass.newInstance();
		Field[] f = objectClass.getDeclaredFields();
	    for (Field a : f) {
	        MockStringAttribute i = a.getAnnotation(
	        		MockStringAttribute.class);
	        if (i != null) {
	            a.setAccessible(true);
	        	Object fieldInstance= null;
	            try {
	            	fieldInstance=a.getType().newInstance();
	            	if (String.class.equals(a.getType())){ 
                		callSetter(instance, a, i.value()[randomNumber((i.value().length)-1,0)]);
					}else{
		            	Field[] fafafa = fieldInstance.getClass().getDeclaredFields();
		            	for (Field field : fafafa) {
		            		if (String.class.equals(field.getType())){ //Busca el campo String
		                		Object property=field.getType().newInstance(); 
		                		callSetter(fieldInstance, field, i.value()[randomNumber((i.value().length)-1,0)]);
							}
						}
		        		callSetter(instance, a, fieldInstance);
	        		}		
	            } catch (Exception e) {
	                System.err.println("Error: " + e.getMessage());
	            }
	        }else{
	        	  MockTodayAttribute today = a.getAnnotation(
	  	        		MockTodayAttribute.class);
	        	 if(today !=null){
		        	 a.setAccessible(true);
			         callSetter(instance, a, new Date());
	        	 }
	        }
	    }
	    return instance;
	}	
	
	private static void callSetter(Object contenedor, Field field, Object value){
		try {
			String propertyName= field.getName();
			String methodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
			Method setter = contenedor.getClass().getMethod(methodName, (Class<?>) field.getType());
			setter.invoke(contenedor, value);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
	}
	
	private static int randomNumber(int max, int min){
		
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

}
