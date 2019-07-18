// --------------------------------------------------------
// Generated by sql2java - http://sql2java.sourceforge.net/
// jdbc driver used at code generation time: org.hsqldb.jdbcDriver
//
// Please help us improve this tool by reporting:
//    problems,
//    suggestions,
//    feedbacks,
//    ideas,
//  to http://sourceforge.net/projects/sql2java/
// --------------------------------------------------------

package com.yumka.leman.database;

// imports+

// imports-

public class QuestionsBean
// extends+

// extends-
{
  private String id;
  private boolean id_is_modified = false;
  private boolean id_is_initialized = false;

  private String topic;
  private boolean topic_is_modified = false;
  private boolean topic_is_initialized = false;

  private String question;
  private boolean question_is_modified = false;
  private boolean question_is_initialized = false;

  private boolean _isNew = true;

  /**
   * Do not use this constructor directly, please use the factory method
   * available in the associated manager.
   */
  QuestionsBean() {
  }

  /**
   * Getter method for id.
   * <br>
   * PRIMARY KEY.<br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: QUESTIONS.ID
   * <li>column size: 10
   * <li>jdbc type returned by the driver: Types.VARCHAR
   * </ul>
   *
   * @return the value of id
   */ public String getId() {
    return id;
  }

  /**
   * Setter method for id.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to id
   */
  public void setId(String newVal) {
    if ( (newVal != null && this.id != null && (newVal.compareTo(this.id) == 0)) ||
        (newVal == null && this.id == null && id_is_initialized)) {
      return;
    }
    this.id = newVal;
    id_is_modified = true;
    id_is_initialized = true;
  }

  /**
   * Determines if the id has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isIdModified() {
    return id_is_modified;
  }

  /**
   * Determines if the id has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isIdInitialized() {
    return id_is_initialized;
  }

  /**
   * Getter method for topic.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: QUESTIONS.TOPIC
   * <li> foreign key: ISOPOINTS.ID
   * <li>column size: 10
   * <li>jdbc type returned by the driver: Types.VARCHAR
   * </ul>
   *
   * @return the value of topic
   */
  public String getTopic() {
    return topic;
  }

  /**
   * Setter method for topic.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to topic
   */
  public void setTopic(String newVal) {
    if ( (newVal != null && this.topic != null &&
          (newVal.compareTo(this.topic) == 0)) ||
        (newVal == null && this.topic == null && topic_is_initialized)) {
      return;
    }
    this.topic = newVal;
    topic_is_modified = true;
    topic_is_initialized = true;
  }

  /**
   * Determines if the topic has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isTopicModified() {
    return topic_is_modified;
  }

  /**
   * Determines if the topic has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isTopicInitialized() {
    return topic_is_initialized;
  }

  /**
   * Getter method for question.
   * <br>
   * Meta Data Information (in progress):
   * <ul>
   * <li>full name: QUESTIONS.QUESTION
   * <li>column size: 500
   * <li>jdbc type returned by the driver: Types.VARCHAR
   * </ul>
   *
   * @return the value of question
   */
  public String getQuestion() {
    return question;
  }

  /**
   * Setter method for question.
   * <br>
   * The new value is set only if compareTo() says it is different,
   * or if one of either the new value or the current value is null.
   * In case the new value is different, it is set and the field is marked as 'modified'.
   *
   * @param newVal the new value to be assigned to question
   */
  public void setQuestion(String newVal) {
    if ( (newVal != null && this.question != null &&
          (newVal.compareTo(this.question) == 0)) ||
        (newVal == null && this.question == null && question_is_initialized)) {
      return;
    }
    this.question = newVal;
    question_is_modified = true;
    question_is_initialized = true;
  }

  /**
   * Determines if the question has been modified.
   *
   * @return true if the field has been modified, false if the field has not been modified
   */
  public boolean isQuestionModified() {
    return question_is_modified;
  }

  /**
   * Determines if the question has been initialized.
   * <br>
   * It is useful to determine if a field is null on purpose or just because it has not been initialized.
   *
   * @return true if the field has been initialized, false otherwise
   */
  public boolean isQuestionInitialized() {
    return question_is_initialized;
  }

  /**
   * Determines if the current object is new.
   *
   * @return true if the current object is new, false if the object is not new
   */
  public boolean isNew() {
    return _isNew;
  }

  /**
   * Specifies to the object if it has been set as new.
   *
   * @param isNew the boolean value to be assigned to the isNew field
   */
  public void isNew(boolean isNew) {
    this._isNew = isNew;
  }

  /**
   * Determines if the object has been modified since the last time this method was called.
   * <br>
   * We can also determine if this object has ever been modified since its creation.
   *
   * @return true if the object has been modified, false if the object has not been modified
   */
  public boolean isModified() {
    return id_is_modified || topic_is_modified || question_is_modified;
  }

  /**
   * Resets the object modification status to 'not modified'.
   */
  public void resetIsModified() {
    id_is_modified = false;
    topic_is_modified = false;
    question_is_modified = false;
  }

  /**
   * Copies the passed bean into the current bean.
   *
   * @param bean the bean to copy into the current bean
   */
  public void copy(QuestionsBean bean) {
    setId(bean.getId());
    setTopic(bean.getTopic());
    setQuestion(bean.getQuestion());
  }

  /**
   * Returns the object string representation.
   *
   * @return the object as a string
   */
  public String toString() {
    return "\n[QUESTIONS] " + "\n - QUESTIONS.ID = " +
        (id_is_initialized ? ("[" + (id == null ? null : id.toString()) + "]") :
         "not initialized") + "" + "\n - QUESTIONS.TOPIC = " +
        (topic_is_initialized ?
         ("[" + (topic == null ? null : topic.toString()) + "]") :
         "not initialized") + "" + "\n - QUESTIONS.QUESTION = " +
        (question_is_initialized ?
         ("[" + (question == null ? null : question.toString()) + "]") :
         "not initialized") + "";
  }

// class+

// class-
}