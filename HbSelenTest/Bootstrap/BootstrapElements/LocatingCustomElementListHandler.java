package BootstrapElements;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.seleniumhq.jetty7.util.log.Log;

public class LocatingCustomElementListHandler implements InvocationHandler{
	 private final ElementLocator locator;
     private final Class<?> clazz;
     private final Field field;

     public LocatingCustomElementListHandler(ElementLocator locator, 
                     Field field) {
         this.locator = locator;
         clazz = (Class<?>) ((ParameterizedType) field.getGenericType()).
                 getActualTypeArguments()[0];
         this.field=field;
         //Log.info("MyList: "+this.clazz.getName()+" IsAssignable for container: "+IContainer.class.isAssignableFrom(clazz));
         
     }
     @Override
     public Object invoke(Object object, Method method, 
                     Object[] objects) throws Throwable {
         // Ќаходит список WebElement и обрабатывает каждый его элемент,
         // возвращает новый список с элементами кастомного класса
         List<WebElement> elements = locator.findElements();
         List<IElement> customsElem = new ArrayList<IElement>();
         List<IContainer> customsContainer = new ArrayList<IContainer>();
         List<?> customs=null;
         Log.info("clazz="+clazz);
         
         if(IContainer.class.isAssignableFrom(clazz)){
        	 Log.info("This is message in container");
	         for (WebElement element : elements) {
	             //customs.add(WrapperFactory.createInstance(clazz, element));
	        	 customsContainer.add(new ContainerFactory().create((Class<IContainer>)clazz, element));
	        	 Log.info("Container "+clazz.getName()+" "+element.getText() );
	        	 //customs.add((new MyFieldDecorator(element));
	         }
	         customs=customsContainer;
	         return method.invoke(customs, objects);
         }
         if(IElement.class.isAssignableFrom(clazz)){
        	 Log.info("This is message in element");
        	 for (WebElement element : elements) {
	             //customs.add(WrapperFactory.createInstance(clazz, element));
	        	 customsElem.add(new ElementFactory().create((Class<IElement>)clazz, element));
	        	 Log.info("element "+clazz.getName()+" "+element.getText() );
	        	 //customs.add((new MyFieldDecorator(element));
	         }
	         customs=customsElem;
	         return method.invoke(customs, objects);
         }
         try {
             return method.invoke(customs, objects);
         } catch (InvocationTargetException e) {
             throw e.getCause();
         }
     }

	
}
