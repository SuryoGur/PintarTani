package pintartani;

import com.sun.javafx.collections.ObservableListWrapper;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.mapper.Mapper;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ObservableListConverter extends CollectionConverter implements Converter {
    public ObservableListConverter(Mapper mapper) {
        super(mapper);
    }

    @Override
    public boolean canConvert(Class type) {
        return ObservableList.class.isAssignableFrom(type);
    }

    @Override
    protected Object createCollection(Class type) {
        if (type == ObservableListWrapper.class) {
            return FXCollections.observableArrayList();
        }
        if (type.getName().indexOf("$") > 0) {
            if (type.getName().equals("javafx.collections.FXCollections$SynchronizedObservableList")) {
                return FXCollections.synchronizedObservableList(FXCollections.observableArrayList());
            }
        }
        return new SimpleListProperty<>(FXCollections.observableArrayList());
    }
}
