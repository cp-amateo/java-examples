/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.amateo.java.examples.messaging.kafka.event;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class CustomerEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1671922512540461904L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CustomerEvent\",\"namespace\":\"com.amateo.java.examples.messaging.kafka.event\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"firstName\",\"type\":\"string\"},{\"name\":\"lastName\",\"type\":\"string\"},{\"name\":\"email\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<CustomerEvent> ENCODER =
      new BinaryMessageEncoder<CustomerEvent>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CustomerEvent> DECODER =
      new BinaryMessageDecoder<CustomerEvent>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<CustomerEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<CustomerEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<CustomerEvent>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this CustomerEvent to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a CustomerEvent from a ByteBuffer. */
  public static CustomerEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence id;
  @Deprecated public java.lang.CharSequence firstName;
  @Deprecated public java.lang.CharSequence lastName;
  @Deprecated public java.lang.CharSequence email;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CustomerEvent() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param firstName The new value for firstName
   * @param lastName The new value for lastName
   * @param email The new value for email
   */
  public CustomerEvent(java.lang.CharSequence id, java.lang.CharSequence firstName, java.lang.CharSequence lastName, java.lang.CharSequence email) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return firstName;
    case 2: return lastName;
    case 3: return email;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: firstName = (java.lang.CharSequence)value$; break;
    case 2: lastName = (java.lang.CharSequence)value$; break;
    case 3: email = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'firstName' field.
   * @return The value of the 'firstName' field.
   */
  public java.lang.CharSequence getFirstName() {
    return firstName;
  }

  /**
   * Sets the value of the 'firstName' field.
   * @param value the value to set.
   */
  public void setFirstName(java.lang.CharSequence value) {
    this.firstName = value;
  }

  /**
   * Gets the value of the 'lastName' field.
   * @return The value of the 'lastName' field.
   */
  public java.lang.CharSequence getLastName() {
    return lastName;
  }

  /**
   * Sets the value of the 'lastName' field.
   * @param value the value to set.
   */
  public void setLastName(java.lang.CharSequence value) {
    this.lastName = value;
  }

  /**
   * Gets the value of the 'email' field.
   * @return The value of the 'email' field.
   */
  public java.lang.CharSequence getEmail() {
    return email;
  }

  /**
   * Sets the value of the 'email' field.
   * @param value the value to set.
   */
  public void setEmail(java.lang.CharSequence value) {
    this.email = value;
  }

  /**
   * Creates a new CustomerEvent RecordBuilder.
   * @return A new CustomerEvent RecordBuilder
   */
  public static com.amateo.java.examples.messaging.kafka.event.CustomerEvent.Builder newBuilder() {
    return new com.amateo.java.examples.messaging.kafka.event.CustomerEvent.Builder();
  }

  /**
   * Creates a new CustomerEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CustomerEvent RecordBuilder
   */
  public static com.amateo.java.examples.messaging.kafka.event.CustomerEvent.Builder newBuilder(com.amateo.java.examples.messaging.kafka.event.CustomerEvent.Builder other) {
    return new com.amateo.java.examples.messaging.kafka.event.CustomerEvent.Builder(other);
  }

  /**
   * Creates a new CustomerEvent RecordBuilder by copying an existing CustomerEvent instance.
   * @param other The existing instance to copy.
   * @return A new CustomerEvent RecordBuilder
   */
  public static com.amateo.java.examples.messaging.kafka.event.CustomerEvent.Builder newBuilder(com.amateo.java.examples.messaging.kafka.event.CustomerEvent other) {
    return new com.amateo.java.examples.messaging.kafka.event.CustomerEvent.Builder(other);
  }

  /**
   * RecordBuilder for CustomerEvent instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CustomerEvent>
    implements org.apache.avro.data.RecordBuilder<CustomerEvent> {

    private java.lang.CharSequence id;
    private java.lang.CharSequence firstName;
    private java.lang.CharSequence lastName;
    private java.lang.CharSequence email;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.amateo.java.examples.messaging.kafka.event.CustomerEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.firstName)) {
        this.firstName = data().deepCopy(fields()[1].schema(), other.firstName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.lastName)) {
        this.lastName = data().deepCopy(fields()[2].schema(), other.lastName);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.email)) {
        this.email = data().deepCopy(fields()[3].schema(), other.email);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing CustomerEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.amateo.java.examples.messaging.kafka.event.CustomerEvent other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.firstName)) {
        this.firstName = data().deepCopy(fields()[1].schema(), other.firstName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.lastName)) {
        this.lastName = data().deepCopy(fields()[2].schema(), other.lastName);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.email)) {
        this.email = data().deepCopy(fields()[3].schema(), other.email);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.amateo.java.examples.messaging.kafka.event.CustomerEvent.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.amateo.java.examples.messaging.kafka.event.CustomerEvent.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'firstName' field.
      * @return The value.
      */
    public java.lang.CharSequence getFirstName() {
      return firstName;
    }

    /**
      * Sets the value of the 'firstName' field.
      * @param value The value of 'firstName'.
      * @return This builder.
      */
    public com.amateo.java.examples.messaging.kafka.event.CustomerEvent.Builder setFirstName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.firstName = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'firstName' field has been set.
      * @return True if the 'firstName' field has been set, false otherwise.
      */
    public boolean hasFirstName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'firstName' field.
      * @return This builder.
      */
    public com.amateo.java.examples.messaging.kafka.event.CustomerEvent.Builder clearFirstName() {
      firstName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'lastName' field.
      * @return The value.
      */
    public java.lang.CharSequence getLastName() {
      return lastName;
    }

    /**
      * Sets the value of the 'lastName' field.
      * @param value The value of 'lastName'.
      * @return This builder.
      */
    public com.amateo.java.examples.messaging.kafka.event.CustomerEvent.Builder setLastName(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.lastName = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'lastName' field has been set.
      * @return True if the 'lastName' field has been set, false otherwise.
      */
    public boolean hasLastName() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'lastName' field.
      * @return This builder.
      */
    public com.amateo.java.examples.messaging.kafka.event.CustomerEvent.Builder clearLastName() {
      lastName = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'email' field.
      * @return The value.
      */
    public java.lang.CharSequence getEmail() {
      return email;
    }

    /**
      * Sets the value of the 'email' field.
      * @param value The value of 'email'.
      * @return This builder.
      */
    public com.amateo.java.examples.messaging.kafka.event.CustomerEvent.Builder setEmail(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.email = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'email' field has been set.
      * @return True if the 'email' field has been set, false otherwise.
      */
    public boolean hasEmail() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'email' field.
      * @return This builder.
      */
    public com.amateo.java.examples.messaging.kafka.event.CustomerEvent.Builder clearEmail() {
      email = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CustomerEvent build() {
      try {
        CustomerEvent record = new CustomerEvent();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.firstName = fieldSetFlags()[1] ? this.firstName : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.lastName = fieldSetFlags()[2] ? this.lastName : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.email = fieldSetFlags()[3] ? this.email : (java.lang.CharSequence) defaultValue(fields()[3]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CustomerEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<CustomerEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CustomerEvent>
    READER$ = (org.apache.avro.io.DatumReader<CustomerEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}