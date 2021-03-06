/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.memcache.v1beta2;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.memcache.v1beta2.stub.CloudMemcacheStub;
import com.google.cloud.memcache.v1beta2.stub.CloudMemcacheStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Configures and manages Cloud Memorystore for Memcached instances.
 *
 * <p>The `memcache.googleapis.com` service implements the Google Cloud Memorystore for Memcached
 * API and defines the following resource model for managing Memorystore Memcached (also called
 * Memcached below) instances: &#42; The service works with a collection of cloud projects, named:
 * `/projects/&#42;` &#42; Each project has a collection of available locations, named:
 * `/locations/&#42;` &#42; Each location has a collection of Memcached instances, named:
 * `/instances/&#42;` &#42; As such, Memcached instances are resources of the form:
 * `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
 *
 * <p>Note that location_id must be refering to a GCP `region`; for example: &#42;
 * `projects/my-memcached-project/locations/us-central1/instances/my-memcached`
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
 *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   Instance response = cloudMemcacheClient.getInstance(name);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the cloudMemcacheClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of CloudMemcacheSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * CloudMemcacheSettings cloudMemcacheSettings =
 *     CloudMemcacheSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudMemcacheClient cloudMemcacheClient =
 *     CloudMemcacheClient.create(cloudMemcacheSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * CloudMemcacheSettings cloudMemcacheSettings =
 *     CloudMemcacheSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudMemcacheClient cloudMemcacheClient =
 *     CloudMemcacheClient.create(cloudMemcacheSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class CloudMemcacheClient implements BackgroundResource {
  private final CloudMemcacheSettings settings;
  private final CloudMemcacheStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of CloudMemcacheClient with default settings. */
  public static final CloudMemcacheClient create() throws IOException {
    return create(CloudMemcacheSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudMemcacheClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CloudMemcacheClient create(CloudMemcacheSettings settings)
      throws IOException {
    return new CloudMemcacheClient(settings);
  }

  /**
   * Constructs an instance of CloudMemcacheClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use CloudMemcacheSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final CloudMemcacheClient create(CloudMemcacheStub stub) {
    return new CloudMemcacheClient(stub);
  }

  /**
   * Constructs an instance of CloudMemcacheClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CloudMemcacheClient(CloudMemcacheSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CloudMemcacheStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected CloudMemcacheClient(CloudMemcacheStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final CloudMemcacheSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public CloudMemcacheStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Instance element : cloudMemcacheClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the instance location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(LocationName parent) {
    ListInstancesRequest request =
        ListInstancesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Instance element : cloudMemcacheClient.listInstances(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the instance location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(String parent) {
    ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(parent).build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListInstancesRequest request = ListInstancesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Instance element : cloudMemcacheClient.listInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(ListInstancesRequest request) {
    return listInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListInstancesRequest request = ListInstancesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListInstancesPagedResponse&gt; future = cloudMemcacheClient.listInstancesPagedCallable().futureCall(request);
   *   // Do something
   *   for (Instance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return stub.listInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListInstancesRequest request = ListInstancesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListInstancesResponse response = cloudMemcacheClient.listInstancesCallable().call(request);
   *     for (Instance element : response.getResourcesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Instance response = cloudMemcacheClient.getInstance(name);
   * }
   * </code></pre>
   *
   * @param name Required. Memcached instance resource name in the format:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(InstanceName name) {
    GetInstanceRequest request =
        GetInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Instance response = cloudMemcacheClient.getInstance(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. Memcached instance resource name in the format:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(String name) {
    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(name).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   GetInstanceRequest request = GetInstanceRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Instance response = cloudMemcacheClient.getInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(GetInstanceRequest request) {
    return getInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   GetInstanceRequest request = GetInstanceRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Instance&gt; future = cloudMemcacheClient.getInstanceCallable().futureCall(request);
   *   // Do something
   *   Instance response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return stub.getInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String instanceId = "";
   *   Instance resource = Instance.newBuilder().build();
   *   Instance response = cloudMemcacheClient.createInstanceAsync(parent, instanceId, resource).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the instance location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region
   * @param instanceId Required. The logical name of the Memcached instance in the user project with
   *     the following restrictions:
   *     <p>&#42; Must contain only lowercase letters, numbers, and hyphens. &#42; Must start with a
   *     letter. &#42; Must be between 1-40 characters. &#42; Must end with a number or a letter.
   *     &#42; Must be unique within the user project / location
   * @param resource Required. A Memcached [Instance] resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      LocationName parent, String instanceId, Instance resource) {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInstanceId(instanceId)
            .setResource(resource)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String instanceId = "";
   *   Instance resource = Instance.newBuilder().build();
   *   Instance response = cloudMemcacheClient.createInstanceAsync(parent.toString(), instanceId, resource).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the instance location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region
   * @param instanceId Required. The logical name of the Memcached instance in the user project with
   *     the following restrictions:
   *     <p>&#42; Must contain only lowercase letters, numbers, and hyphens. &#42; Must start with a
   *     letter. &#42; Must be between 1-40 characters. &#42; Must end with a number or a letter.
   *     &#42; Must be unique within the user project / location
   * @param resource Required. A Memcached [Instance] resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      String parent, String instanceId, Instance resource) {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent)
            .setInstanceId(instanceId)
            .setResource(resource)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String instanceId = "";
   *   Instance resource = Instance.newBuilder().build();
   *   CreateInstanceRequest request = CreateInstanceRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setInstanceId(instanceId)
   *     .setResource(resource)
   *     .build();
   *   Instance response = cloudMemcacheClient.createInstanceAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      CreateInstanceRequest request) {
    return createInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String instanceId = "";
   *   Instance resource = Instance.newBuilder().build();
   *   CreateInstanceRequest request = CreateInstanceRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setInstanceId(instanceId)
   *     .setResource(resource)
   *     .build();
   *   OperationFuture&lt;Instance, OperationMetadata&gt; future = cloudMemcacheClient.createInstanceOperationCallable().futureCall(request);
   *   // Do something
   *   Instance response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return stub.createInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String instanceId = "";
   *   Instance resource = Instance.newBuilder().build();
   *   CreateInstanceRequest request = CreateInstanceRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setInstanceId(instanceId)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = cloudMemcacheClient.createInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return stub.createInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Instance resource = Instance.newBuilder().build();
   *   Instance response = cloudMemcacheClient.updateInstanceAsync(updateMask, resource).get();
   * }
   * </code></pre>
   *
   * @param updateMask Required. Mask of fields to update. &#42; `displayName`
   * @param resource Required. A Memcached [Instance] resource. Only fields specified in update_mask
   *     are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Instance, OperationMetadata> updateInstanceAsync(
      FieldMask updateMask, Instance resource) {
    UpdateInstanceRequest request =
        UpdateInstanceRequest.newBuilder().setUpdateMask(updateMask).setResource(resource).build();
    return updateInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Instance resource = Instance.newBuilder().build();
   *   UpdateInstanceRequest request = UpdateInstanceRequest.newBuilder()
   *     .setUpdateMask(updateMask)
   *     .setResource(resource)
   *     .build();
   *   Instance response = cloudMemcacheClient.updateInstanceAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Instance, OperationMetadata> updateInstanceAsync(
      UpdateInstanceRequest request) {
    return updateInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Instance resource = Instance.newBuilder().build();
   *   UpdateInstanceRequest request = UpdateInstanceRequest.newBuilder()
   *     .setUpdateMask(updateMask)
   *     .setResource(resource)
   *     .build();
   *   OperationFuture&lt;Instance, OperationMetadata&gt; future = cloudMemcacheClient.updateInstanceOperationCallable().futureCall(request);
   *   // Do something
   *   Instance response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    return stub.updateInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Instance resource = Instance.newBuilder().build();
   *   UpdateInstanceRequest request = UpdateInstanceRequest.newBuilder()
   *     .setUpdateMask(updateMask)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = cloudMemcacheClient.updateInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return stub.updateInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the defined Memcached Parameters for an existing Instance. This method only stages the
   * parameters, it must be followed by ApplyParameters to apply the parameters to nodes of the
   * Memcached Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MemcacheParameters parameters = MemcacheParameters.newBuilder().build();
   *   Instance response = cloudMemcacheClient.updateParametersAsync(name, updateMask, parameters).get();
   * }
   * </code></pre>
   *
   * @param name Required. Resource name of the Memcached instance for which the parameters should
   *     be updated.
   * @param updateMask Required. Mask of fields to update.
   * @param parameters The parameters to apply to the instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Instance, OperationMetadata> updateParametersAsync(
      InstanceName name, FieldMask updateMask, MemcacheParameters parameters) {
    UpdateParametersRequest request =
        UpdateParametersRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setUpdateMask(updateMask)
            .setParameters(parameters)
            .build();
    return updateParametersAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the defined Memcached Parameters for an existing Instance. This method only stages the
   * parameters, it must be followed by ApplyParameters to apply the parameters to nodes of the
   * Memcached Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MemcacheParameters parameters = MemcacheParameters.newBuilder().build();
   *   Instance response = cloudMemcacheClient.updateParametersAsync(name.toString(), updateMask, parameters).get();
   * }
   * </code></pre>
   *
   * @param name Required. Resource name of the Memcached instance for which the parameters should
   *     be updated.
   * @param updateMask Required. Mask of fields to update.
   * @param parameters The parameters to apply to the instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Instance, OperationMetadata> updateParametersAsync(
      String name, FieldMask updateMask, MemcacheParameters parameters) {
    UpdateParametersRequest request =
        UpdateParametersRequest.newBuilder()
            .setName(name)
            .setUpdateMask(updateMask)
            .setParameters(parameters)
            .build();
    return updateParametersAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the defined Memcached Parameters for an existing Instance. This method only stages the
   * parameters, it must be followed by ApplyParameters to apply the parameters to nodes of the
   * Memcached Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateParametersRequest request = UpdateParametersRequest.newBuilder()
   *     .setName(name.toString())
   *     .setUpdateMask(updateMask)
   *     .build();
   *   Instance response = cloudMemcacheClient.updateParametersAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Instance, OperationMetadata> updateParametersAsync(
      UpdateParametersRequest request) {
    return updateParametersOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the defined Memcached Parameters for an existing Instance. This method only stages the
   * parameters, it must be followed by ApplyParameters to apply the parameters to nodes of the
   * Memcached Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateParametersRequest request = UpdateParametersRequest.newBuilder()
   *     .setName(name.toString())
   *     .setUpdateMask(updateMask)
   *     .build();
   *   OperationFuture&lt;Instance, OperationMetadata&gt; future = cloudMemcacheClient.updateParametersOperationCallable().futureCall(request);
   *   // Do something
   *   Instance response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<UpdateParametersRequest, Instance, OperationMetadata>
      updateParametersOperationCallable() {
    return stub.updateParametersOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the defined Memcached Parameters for an existing Instance. This method only stages the
   * parameters, it must be followed by ApplyParameters to apply the parameters to nodes of the
   * Memcached Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateParametersRequest request = UpdateParametersRequest.newBuilder()
   *     .setName(name.toString())
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = cloudMemcacheClient.updateParametersCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateParametersRequest, Operation> updateParametersCallable() {
    return stub.updateParametersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   String name = "";
   *   cloudMemcacheClient.deleteInstanceAsync(name).get();
   * }
   * </code></pre>
   *
   * @param name Memcached instance resource name in the format:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a GCP region
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(String name) {
    DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().setName(name).build();
    return deleteInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().build();
   *   cloudMemcacheClient.deleteInstanceAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(
      DeleteInstanceRequest request) {
    return deleteInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().build();
   *   OperationFuture&lt;Empty, OperationMetadata&gt; future = cloudMemcacheClient.deleteInstanceOperationCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return stub.deleteInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().build();
   *   ApiFuture&lt;Operation&gt; future = cloudMemcacheClient.deleteInstanceCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return stub.deleteInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * ApplyParameters will update current set of Parameters to the set of specified nodes of the
   * Memcached Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   List&lt;String&gt; nodeIds = new ArrayList&lt;&gt;();
   *   boolean applyAll = false;
   *   Instance response = cloudMemcacheClient.applyParametersAsync(name, nodeIds, applyAll).get();
   * }
   * </code></pre>
   *
   * @param name Required. Resource name of the Memcached instance for which parameter group updates
   *     should be applied.
   * @param nodeIds Nodes to which we should apply the instance-level parameter group.
   * @param applyAll Whether to apply instance-level parameter group to all nodes. If set to true,
   *     will explicitly restrict users from specifying any nodes, and apply parameter group updates
   *     to all nodes within the instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Instance, OperationMetadata> applyParametersAsync(
      InstanceName name, List<String> nodeIds, boolean applyAll) {
    ApplyParametersRequest request =
        ApplyParametersRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .addAllNodeIds(nodeIds)
            .setApplyAll(applyAll)
            .build();
    return applyParametersAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * ApplyParameters will update current set of Parameters to the set of specified nodes of the
   * Memcached Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   List&lt;String&gt; nodeIds = new ArrayList&lt;&gt;();
   *   boolean applyAll = false;
   *   Instance response = cloudMemcacheClient.applyParametersAsync(name.toString(), nodeIds, applyAll).get();
   * }
   * </code></pre>
   *
   * @param name Required. Resource name of the Memcached instance for which parameter group updates
   *     should be applied.
   * @param nodeIds Nodes to which we should apply the instance-level parameter group.
   * @param applyAll Whether to apply instance-level parameter group to all nodes. If set to true,
   *     will explicitly restrict users from specifying any nodes, and apply parameter group updates
   *     to all nodes within the instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Instance, OperationMetadata> applyParametersAsync(
      String name, List<String> nodeIds, boolean applyAll) {
    ApplyParametersRequest request =
        ApplyParametersRequest.newBuilder()
            .setName(name)
            .addAllNodeIds(nodeIds)
            .setApplyAll(applyAll)
            .build();
    return applyParametersAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * ApplyParameters will update current set of Parameters to the set of specified nodes of the
   * Memcached Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   ApplyParametersRequest request = ApplyParametersRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Instance response = cloudMemcacheClient.applyParametersAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Instance, OperationMetadata> applyParametersAsync(
      ApplyParametersRequest request) {
    return applyParametersOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * ApplyParameters will update current set of Parameters to the set of specified nodes of the
   * Memcached Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   ApplyParametersRequest request = ApplyParametersRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   OperationFuture&lt;Instance, OperationMetadata&gt; future = cloudMemcacheClient.applyParametersOperationCallable().futureCall(request);
   *   // Do something
   *   Instance response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<ApplyParametersRequest, Instance, OperationMetadata>
      applyParametersOperationCallable() {
    return stub.applyParametersOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * ApplyParameters will update current set of Parameters to the set of specified nodes of the
   * Memcached Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   ApplyParametersRequest request = ApplyParametersRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = cloudMemcacheClient.applyParametersCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ApplyParametersRequest, Operation> applyParametersCallable() {
    return stub.applyParametersCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    public static ApiFuture<ListInstancesPagedResponse> createAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      ApiFuture<ListInstancesPage> futurePage =
          ListInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListInstancesPage, ListInstancesPagedResponse>() {
            @Override
            public ListInstancesPagedResponse apply(ListInstancesPage input) {
              return new ListInstancesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListInstancesPagedResponse(ListInstancesPage page) {
      super(page, ListInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstancesPage
      extends AbstractPage<
          ListInstancesRequest, ListInstancesResponse, Instance, ListInstancesPage> {

    private ListInstancesPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      super(context, response);
    }

    private static ListInstancesPage createEmptyPage() {
      return new ListInstancesPage(null, null);
    }

    @Override
    protected ListInstancesPage createPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      return new ListInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListInstancesPage> createPageAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    private ListInstancesFixedSizeCollection(List<ListInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstancesFixedSizeCollection createEmptyCollection() {
      return new ListInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstancesFixedSizeCollection createCollection(
        List<ListInstancesPage> pages, int collectionSize) {
      return new ListInstancesFixedSizeCollection(pages, collectionSize);
    }
  }
}
