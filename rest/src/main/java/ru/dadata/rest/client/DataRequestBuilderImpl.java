package ru.dadata.rest.client;

import org.apache.log4j.Logger;
import ru.dadata.rest.api.DataRequest;
import ru.dadata.rest.api.DataRequestBuilder;
import ru.dadata.rest.api.QueryFieldType;

import java.util.*;

final class DataRequestBuilderImpl implements DataRequestBuilder {
    private static final Logger LOGGER = Logger.getLogger(DataRequestBuilderImpl.class);
    private final List<Record> records = new ArrayList<Record>();

    public DataRequestBuilder addRecord() {
        records.add(new Record());
        return this;
    }

    public DataRequestBuilder set(QueryFieldType type, String data) {
        if (records.size() == 0)
            throw new ArrayIndexOutOfBoundsException("Record not set");
        Record record = records.get(records.size() - 1);
        record.set(type, data);
        return this;
    }

    public Set<QueryFieldType> createStructure() {
        Set<QueryFieldType> fields = new HashSet<QueryFieldType>();
        for (Record r : records) {
            for (Map.Entry<QueryFieldType, String> entry : r.query.entrySet()) {
                fields.add(entry.getKey());
            }
        }
        return fields;
    }

    public DataRequest create() {
        Set<QueryFieldType> fields = createStructure();
        DataRequest request = new DataRequest();
        request.structure = new String[fields.size()];
        int i = 0;
        for (QueryFieldType field : fields) {
            request.structure[i++] = field.name();
            LOGGER.debug("Field: " + field.name());
        }
        for (Record r : records) {
            List<String> data = new ArrayList<String>();
            for (QueryFieldType field : fields) {
                String value = r.query.get(field);
                if (value == null)
                    value = "";
                data.add(value);
            }
            String[] strings = data.toArray(new String[data.size()]);
            request.data.add(strings);
        }
        return request;
    }

    public DataRequestBuilder reset() {
        records.clear();
        return this;
    }

    protected final class Record {
        private final Map<QueryFieldType, String> query =
                new HashMap<QueryFieldType, String>();

        protected void set(QueryFieldType type, String data) {
            if (query.containsKey(type)) {
                LOGGER.warn("Type " + type + " already set in record");
            }
            query.put(type, data);
        }
    }
}
